package LocalStorageImpl.Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.NoSuchFileException;

import org.apache.commons.io.FileUtils;
import java.nio.file.*;
import file.FileBasicOperation;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class BasicOps implements FileBasicOperation {

	private static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	public void uploadFile(String path, String newPath) {

		File file = new File(path);

		if (getFileExtension(file) != "exe") {
			try {
				FileUtils.moveFileToDirectory(FileUtils.getFile(path), FileUtils.getFile(newPath), true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			throw new IllegalArgumentException();
		System.out.println("Upload file successful.");

	}

	public void downloadFile(String path, String storagePath) {
		try {
			FileUtils.moveFileToDirectory(FileUtils.getFile(storagePath), FileUtils.getFile(path), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Download file successful.");

	}

	public void zipFile(String path, String storagePath) throws IOException {
		String sourceFile = path;
		String afterZipName = storagePath;
		FileOutputStream fos = new FileOutputStream(afterZipName);
		ZipOutputStream zipOut = new ZipOutputStream(fos);
		File fileToZip = new File(sourceFile);
		FileInputStream fis = new FileInputStream(fileToZip);
		ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
		zipOut.putNextEntry(zipEntry);
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zipOut.write(bytes, 0, length);
		}
		zipOut.close();
		fis.close();
		fos.close();

	}

	public void multiFileZip(String[] sourceFiles) {
		String zipFile = "C:/archive.zip";

		try {

			// create byte buffer
			byte[] buffer = new byte[1024];

			FileOutputStream fos = new FileOutputStream(zipFile);

			ZipOutputStream zos = new ZipOutputStream(fos);

			for (int i = 0; i < sourceFiles.length; i++) {

				File srcFile = new File(sourceFiles[i]);

				FileInputStream fis = new FileInputStream(srcFile);

				// begin writing a new ZIP entry, positions the stream to the start of the entry
				// data
				zos.putNextEntry(new ZipEntry(srcFile.getName()));

				int length;

				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}

				zos.closeEntry();

				// close the InputStream
				fis.close();

			}

			// close the ZipOutputStream
			zos.close();

		} catch (IOException ioe) {
			System.out.println("Error creating zip file: " + ioe);
		}

	}

	public void moveFile(String path, String storagePath) {
		// TODO Auto-generated method stub

	}

	public void deleteFile(String path) throws NoSuchFileException, FileNotFoundException {

		new File(path).delete();
		System.out.println("Delete file successful.");
	}

	public void duplicateFile(String storagePath) {
		// TODO Auto-generated method stub

	}

	public void fileConfig(String filePath) {
		// TODO Auto-generated method stub

	}

	public void createDir(String path) {
		Path putanja = Paths.get(path);

		if (!Files.exists(putanja)) {
			try {
				Files.createDirectories(putanja);
			} catch (IOException e) {
				e.printStackTrace();

			}
		}

	}

	public void createFile(String path, String name) throws FileNotFoundException, IOException {
		File newFile = new File(path, name);
		newFile.createNewFile();
		if (newFile.isFile()) {
			System.out.println("Create file successful.");
		}
	}

	public void createStroage(String path, String name) {

		File newFolder = new File(path, name);
		newFolder.mkdir();
		if (newFolder.isDirectory()) {
			System.out.println("Create storage successful.");
		}
		// TODO Auto-generated method stub

	}

}
