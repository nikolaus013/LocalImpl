package LocalStorageImpl.Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import file.FileAdvancedOperation;

public class AdvOps implements FileAdvancedOperation {

	public void metaDataUpload(File file, String path, BasicFileAttributes bf) {
		// TODO Auto-generated method stub

	}

	public void MultiFileUpload(String path, String[] files) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		FileOutputStream fos = new FileOutputStream(path + "zipovanFajl.zip");
		ZipOutputStream zipOut = new ZipOutputStream(fos);
		for (String srcFile : files) {
			File fileToZip = new File(srcFile);
			FileInputStream fis = new FileInputStream(fileToZip);
			ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
			zipOut.putNextEntry(zipEntry);

			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zipOut.write(bytes, 0, length);
			}
			fis.close();
		}
		zipOut.close();
		fos.close();
	}

	public void MultiFileZipUpload(String path, String[] files) {
		Boolean zip = true;

		if (zip) {
			for (String file : files) {
				Path sourcePath = Paths.get(file.toString());
				Path destinationPath = Paths.get(path);

				try {
					Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

	public void findFile(String path, FilenameFilter filter) {
		// TODO Auto-generated method stub

	}

}
