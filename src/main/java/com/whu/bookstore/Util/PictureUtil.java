package com.whu.bookstore.Util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author ：qx.w
 * @description：处理照片上传服务器的问题
 * @modified By：
 * @since ：Created in 2020/3/2 14:39
 */
public class PictureUtil {
    public static String filePathBook = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\bookPhoto\\";;//"/root/lost/lostPhoto/";
    public static String filePathUser = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\bookPhoto\\";
    public static String url = "http://localhost:9010/photo/";

    /**
     * 将文件上传至服务器
     * @param image
     * @param UUID
     * @param filePath
     * @return 直接可以放到数据库里面的路径
     */
    public static String uploadImage(MultipartFile image, String UUID, String filePath){
        String photoName = image.getOriginalFilename();  //获取照片文件名
        String suffixName = photoName.substring(photoName.lastIndexOf(".")).toLowerCase();  //获取文件后缀
        if((!suffixName.equals(".bmp"))
                &&(!suffixName.equals(".jpg"))
                &&(!suffixName.equals(".jpeg"))
                &&(!suffixName.equals(".png"))
                &&(!suffixName.equals(".gif"))){
            return "上传失败，请上传bmp、jpg、jpeg、png、gif文件！";
        }

        String photoUrl = filePath + UUID + suffixName;  //生成新的存储地址

        File dest = new File(photoUrl);
        try {
            image.transferTo(dest);
        } catch (IOException e) {
            //存储图片至服务器失败
            return "图片上传至服务器失败！";
        }
        return url + UUID + suffixName;
    }

//    /**
//     * 删除服务器上的文件
//     * @param UUID
//     */
//    public void deletePhoto(String UUID){
//        objectTable obj = objRepository.findById(UUID).get();
//        String photoName = obj.getPhotoUrl();
//        String suffixName = photoName.substring(photoName.lastIndexOf(".")).toLowerCase();
//
//        File file = new File(filePath + UUID + suffixName);
//        file.delete();
//    }
//
//    /**
//     * 删除服务器上的文件
//     * @param UUID
//     */
//    public void deletePhoto(String UUID, String photoName){
//        String suffixName = photoName.substring(photoName.lastIndexOf(".")).toLowerCase();
//        File file = new File(filePath + UUID + suffixName);
//        file.delete();
//    }
}
