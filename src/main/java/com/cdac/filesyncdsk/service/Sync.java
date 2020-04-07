package com.cdac.filesyncdsk.service;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.hcdc.coedp.ermdsk.service;
//
///**
// *
// * @author Mahima
// */
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Vector;
//
//import com.jcraft.jsch.ChannelSftp.LsEntry;
//import com.jcraft.jsch.SftpException;
//
///*
// * This is the heart of the whole Program. I hope, the descriptions are precise enought.
// */
//public class Sync{
//	public String ServerPath;
//	public File LocalFolder;
//	public sFTPclient client;
//	public ArrayList<String> serverContentList;
//	public ArrayList<String> pathList;
//		
//	public Sync(File local, String to, sFTPclient client){
//		this.LocalFolder = local;
//		this.ServerPath = to;
//		this.client = client;
//	}
//	
//	/*
//	 * Executed once. Sets the Server Directory if it exists. 
//	 * If the local folder doesn't exist on the Server, it creates it.
//
//	 */
//	public void setServerDirectory() throws SftpException{
//		try{
//			client.sftpChannel.cd(ServerPath);
//		}catch(Exception e){
//			GUI.addToConsole(ServerPath + " don't exist on your server!");
//		}
//		
//		String serverFolder = ServerPath.substring(ServerPath.lastIndexOf('/')+1, ServerPath.length());
//		if(!LocalFolder.getName().equals(serverFolder)){
//			try{
//				client.sftpChannel.mkdir(LocalFolder.getName());
//				client.sftpChannel.cd(LocalFolder.getName());
//			} catch (Exception e){
//				client.sftpChannel.cd(LocalFolder.getName());
//			}
//			this.ServerPath = ServerPath + "/" + LocalFolder.getName();
//			GUI.setNewServerFolder(ServerPath);
//		}
//		serverContentList = new ArrayList<String>();
//		pathList = new ArrayList<String>();
//		
//	}
//	
//	//The contentlist contains all Filenames, that should be synchronized
//	public void setToContentList(String ServerFolder) throws SftpException{
//		@SuppressWarnings("unchecked")
//		Vector<LsEntry> fileList = client.sftpChannel.ls(ServerFolder);
//		int size = fileList.size();
//		for(int i = 0; i < size; i++){
//			if(!fileList.get(i).getFilename().startsWith(".")){
//				serverContentList.add(fileList.get(i).getFilename());
//				pathList.add(ServerFolder);
//			}
//		}
//	}
//	
//	/*
//	 * Deletes the synchronized elements from the Lists
//	 */
//	public void deleteFromLists(String name){
//		int	position = serverContentList.lastIndexOf(name);
//				
//		if(position >= 0){	
//			serverContentList.remove(position);
//			pathList.remove(position);
//		}
//	}
//	
//	/*
//	 * Main function for synchronizing. Works recursive for local folders.
//	 */
//	@SuppressWarnings("unchecked")
//	public void synchronize(File localFolder, String ServerDir) throws SftpException, FileNotFoundException{
//		if(client.sftpChannel.pwd() != ServerDir){
//			client.sftpChannel.cd(ServerDir);
//		}
//		setToContentList(ServerDir);
//		
//		File[] localList = localFolder.listFiles();
//		Vector<LsEntry> ServerList = client.sftpChannel.ls(ServerDir);
//		ServerList.remove(0); ServerList.remove(0);
//		
//		/*
//		 * Upload missing Files/Folders
//		 */
//		int size = localList.length;
//		for(int i = 0; i < size; i++){
//			if(localList[i].isDirectory()){
//				if(checkFolder(localList[i], ServerDir)){
//					synchronize(localList[i], ServerDir + "/" + localList[i].getName());
//					deleteFromLists("SubFolder");
//				}else {
//					newFileMaster(true, localList[i], ServerDir);
//				}
//			} else {
//				checkFile(localList[i], ServerDir);
//			}
//			deleteFromLists(localList[i].getName());
//		}
//	}
//	
//	/*
//	 * Deletes all files on the server, which are not in the local Folder. Deletes also all missing folders
//	 */
//	public void deleteRest() throws SftpException, FileNotFoundException{
//		int size = serverContentList.size();
//		for(int i = 0; i < size; i++){
//			client.sftpChannel.cd(pathList.get(i));
//			newFileMaster(false, null, serverContentList.get(i));
//		}
//	}
//	
//	/*
//	 * Copy or delete Files/Folders
//	 */
//	public void newFileMaster(boolean copyOrNot, File sourcePath, String destPath) throws FileNotFoundException, SftpException{
//		FileMaster copy = new FileMaster(copyOrNot, sourcePath, destPath, client.sftpChannel);
//		copy.runMaster();
//	}
//	
//	/*
//	 *Useful to find errors - Prints out the content-List every time you call the method.
//	 *If you have Problems, call it before and after every changes of the serverContentList!
//	 */
//	/*public void printServerContent(){
//		System.out.println("SERVER-Content: " + "\n");
//		for(int i = 0; i < serverContentList.size(); i++){
//			System.out.println(serverContentList.get(i) + " in " + pathList.get(i));
//		}
//	}*/
//	
//	/*
//	 * Looks ond the server, if the file is there. If not, or the local file has changed, it copies the file on the server.
//	 */
//	public void checkFile(File file, String path) throws SftpException, FileNotFoundException{
//		client.sftpChannel.cd(path);
//		
//		if(!serverContentList.contains(file.getName())){
//			newFileMaster(true, file, ServerPath);
//		} else {
//			Long localTimeStamp = file.lastModified();
//			Long timeStamp =  client.sftpChannel.stat(file.getName()).getATime()*1000L;
//
//			if(localTimeStamp > timeStamp){
//				newFileMaster(false, null, path + "/" + file.getName());
//				newFileMaster(true, file, path);
//			}
//		}
//		deleteFromLists(file.getName());
//	}
//	
//	/*
//	 * The same as the checkFile function. But it returns a boolean. (Easier to handle in the synchronized funtion)
//	 * Don't check, if the folder has changed (I think this can't be the case)
//	 */
//	public boolean checkFolder(File folder, String path) throws SftpException{
//		client.sftpChannel.cd(path);
//		if(serverContentList.contains(folder.getName())){
//			return true;
//		}else { return false; }
//	}
//	
//}
