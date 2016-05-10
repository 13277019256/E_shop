package cn.it.shop.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.it.shop.model.FileImage;

/**
 * @Description: TODO(ʵ���ļ��ϴ���ҵ���߼�)
 * @author Ni Shengwu
 *
 */
@Component("fileUpload")
public class FileUploadUtil implements FileUpload {
	
	private String filePath;
	@Value("#{prop.filePath}") 
	//@Value��ʾȥbeans.xml�ļ�����id="prop"��bean������ͨ��ע��ķ�ʽ��ȡproperties�����ļ��ģ�Ȼ��ȥ��Ӧ�������ļ��ж�ȡkey=filePath��ֵ
	public void setFilePath(String filePath) {
		System.out.println(filePath);
		this.filePath = filePath;
	}

	//1. ͨ���ļ�����ȡ��չ��
	private String getFileExt(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}
	
	//2. ����UUID���������Ϊ�µ��ļ���
	private String newFileName(String fileName) {
		String ext = getFileExt(fileName);
		return UUID.randomUUID().toString() + "." + ext;
	}
	
	//ʵ���ļ��ϴ��Ĺ��ܣ������ϴ����µ��ļ�����
	/* (non-Javadoc)
	 * @see cn.it.shop.utils.FileUpload#uploadFile(cn.it.shop.model.FileImage)
	 */
	@Override
	public String uploadFile(FileImage fileImage) {
		//��ȡ��Ψһ�ļ���
		String pic = newFileName(fileImage.getFilename());
		try {
			FileUtil.copyFile(fileImage.getFile(), new File(filePath, pic));
			return pic;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			fileImage.getFile().delete();
		}
	}
}
