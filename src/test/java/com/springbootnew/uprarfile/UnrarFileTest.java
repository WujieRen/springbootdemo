package com.springbootnew.uprarfile;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by renwujie on 2018/06/29 at 10:12
 */
public class UnrarFileTest {

    @Test
    public void test() {
        try {
            //unrar("D:/output.rar", "D:/111111111111111");
            unrar2("D:/output.rar", "D:/111111111111111");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param rarFileName rar file name
     * @param outFilePath output file path
     * @return success Or Failed
     * @author zhuss
     * @throws Exception
     */
    public static boolean  unrar(String rarFileName, String outFilePath)  throws  Exception{

        boolean flag = false;
        try  {
            Archive archive = new  Archive(new File(rarFileName));
            if(archive == null){
                throw new FileNotFoundException(rarFileName + " NOT FOUND!");
            }
            if(archive.isEncrypted()){
                throw new Exception(rarFileName + " IS ENCRYPTED!");
            }
            List<FileHeader> files =  archive.getFileHeaders();
            for (FileHeader fh : files) {
                if(fh.isEncrypted()){
                    throw new Exception(rarFileName + " IS ENCRYPTED!");
                }
                String fileName = fh.getFileNameW();
                if(fileName != null && fileName.trim().length() > 0){
                    String saveFileName = outFilePath+"\\"+fileName;
                    File saveFile = new File(saveFileName);
                    File parent =  saveFile.getParentFile();
                    if(!parent.exists()){
                        parent.mkdirs();
                    }
                    if(!saveFile.exists()){
                        saveFile.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(saveFile);
                    try {
                        archive.extractFile(fh, fos);
                        fos.flush();
                        fos.close();
                    } catch (RarException e) {
                        if(e.getType().equals(RarException.RarExceptionType.notImplementedYet)){
                        }
                    }finally{
                    }
                }
            }
            flag = true;
        } catch  (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return flag;
    }

    private static void unrar2(String sourceRar, String destDir)

            throws Exception {

        Archive a = null;

        FileOutputStream fos = null;

        try {

            a = new Archive(new File(sourceRar));

            FileHeader fh = a.nextFileHeader();

            while (fh != null) {

                if (!fh.isDirectory()) {

// 1 根据不同的操作系统拿到相应的 destDirName 和 destFileName

                    String compressFileName = fh.getFileNameString().trim();

                    String destFileName = "";

                    String destDirName = "";

// 非windows系统

                    if (File.separator.equals("/")) {

                        destFileName = destDir

                                + compressFileName.replaceAll("\\\\", "/");

                        destDirName = destFileName.substring(0,

                                destFileName.lastIndexOf("/"));

// windows系统

                    } else {

                        destFileName = destDir

                                + compressFileName.replaceAll("/", "\\\\");

                        destDirName = destFileName.substring(0,

                                destFileName.lastIndexOf("\\"));

                    }

// 2创建文件夹

                    File dir = new File(destDirName);

                    if (!dir.exists() || !dir.isDirectory()) {

                        dir.mkdirs();

                    }

// 3解压缩文件

                    fos = new FileOutputStream(new File(destFileName));

                    a.extractFile(fh, fos);

                    fos.close();

                    fos = null;

                }

                fh = a.nextFileHeader();

            }

            a.close();

            a = null;

        } catch (Exception e) {

            throw e;

        } finally {

            if (fos != null) {

                try {

                    fos.close();

                    fos = null;

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

            if (a != null) {

                try {

                    a.close();

                    a = null;

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        }

    }

}
