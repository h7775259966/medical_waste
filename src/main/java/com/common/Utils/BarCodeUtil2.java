package com.common.Utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import org.springframework.util.StringUtils;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**生成带中文或字母的条形码
 * Created by Zhouxin on 2020/9/27;
 */
public class BarCodeUtil2 {
    /** 条形码宽度 */
    private static final int WIDTH = 300;

    /** 条形码高度 */
    private static final int HEIGHT = 50;

    /** 加文字 条形码 */
    private static final int WORDHEIGHT = 75;
    private static final int WORDHEIGHT2 = 300;
    /**
     * 设置 条形码参数
     */
    private static Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>() {
        private static final long serialVersionUID = 1L;
        {
            // 设置编码方式
            put(EncodeHintType.CHARACTER_SET, "utf-8");
        }
    };

    /**
     * 生成 图片缓冲
     * @author fxbin
     * @param vaNumber  VA 码
     * @return 返回BufferedImage
     */
    public static BufferedImage getBarCode(String vaNumber){
        try {
            Code128Writer writer = new Code128Writer();
            // 编码内容, 编码类型, 宽度, 高度, 设置参数
            BitMatrix bitMatrix = writer.encode(vaNumber, BarcodeFormat.CODE_128, WIDTH, HEIGHT, hints);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成条形码图片，且下方添加条形码数字
     * @author fxbin
     * @param image  条形码图片
     * @param words  文字
     * @return 返回BufferedImage
     */
    public static BufferedImage insertWords(BufferedImage image, String words){
        if (!StringUtils.isEmpty(words)) {

            BufferedImage outImage = new BufferedImage(WIDTH, WORDHEIGHT, BufferedImage.TYPE_INT_RGB);

            Graphics2D g2d = outImage.createGraphics();

            // 抗锯齿
            setGraphics2D(g2d);
            // 设置白色
            setColorWhite(g2d);

            // 画条形码到新的面板
            g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
            // 画文字到新的面板
            Color color=new Color(0, 0, 0);
            g2d.setColor(color);
            // 字体、字型、字号
            g2d.setFont(new Font("微软雅黑", Font.PLAIN, 18));
            //文字长度
            int strWidth = g2d.getFontMetrics().stringWidth(words);
            //总长度减去文字长度的一半  （居中显示）
            int wordStartX=(WIDTH - strWidth) / 2;
            //height + (outImage.getHeight() - height) / 2 + 12
            int wordStartY=HEIGHT+20;//文字显示在条形码下方

            // 画文字
            g2d.drawString(words, wordStartX, wordStartY);
            g2d.dispose();
            outImage.flush();
            return outImage;
        }
        return null;
    }


    public static BufferedImage insertWords2(BufferedImage image, String words,String words2){
        if (!StringUtils.isEmpty(words)) {

            BufferedImage outImage = new BufferedImage(WIDTH, WORDHEIGHT2, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = outImage.createGraphics();
            setGraphics2D(g2d);
            setColorWhite(g2d);
            Color color=new Color(0, 0, 0);
            g2d.setColor(color);
            g2d.setFont(new Font("微软雅黑", Font.PLAIN, 18));

            int strWidth2 = g2d.getFontMetrics().stringWidth(words2);
            int wordStartX2=(WIDTH - strWidth2) / 2;
            int wordStartY2=HEIGHT;

            int strWidth = g2d.getFontMetrics().stringWidth(words);
            int wordStartX=(WIDTH - strWidth) / 2;
            int wordStartY=HEIGHT+80;

            // 科室名字
            g2d.drawString(words2, wordStartX2, wordStartY2);
            // 画条形码到新的面板
            g2d.drawImage(image, 0, 60, image.getWidth(), image.getHeight(), null);
            // 条形码数字
            g2d.drawString(words, wordStartX, wordStartY);


            g2d.dispose();
            outImage.flush();
            return outImage;
        }
        return null;
    }

    /**
     * 设置 Graphics2D 属性  （抗锯齿）
     * @param g2d  Graphics2D提供对几何形状、坐标转换、颜色管理和文本布局更为复杂的控制
     */
    private static void setGraphics2D(Graphics2D g2d){
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
        Stroke s = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(s);
    }

    /**
     * 设置背景为白色
     * @param g2d Graphics2D提供对几何形状、坐标转换、颜色管理和文本布局更为复杂的控制
     */
    private static void setColorWhite(Graphics2D g2d){
        g2d.setColor(Color.WHITE);
        //填充整个屏幕
        g2d.fillRect(0,0,600,600);
        //设置笔刷
        g2d.setColor(Color.BLACK);
    }

/*    public static void main(String[] args) throws IOException {
        System.out.println("开始生成条形码图片");
        BufferedImage image = insertWords(getBarCode("123456789"), "123456789");
        ImageIO.write(image, "jpg", new File("D://a1.jpg"));
        System.out.println("条形码生成完成：D://a1.jpg");
        System.out.println("----------------------------------------");
        System.out.println("条形码图片上方添加科室文字");
        BufferedImage image2 = insertWords2(getBarCode("123456789"), "123456789","(放射科)");
        ImageIO.write(image2, "jpg", new File("D://a2.jpg"));
        System.out.println("添加科室文字后生成新图片：D://a2.jpg");
    }*/
}
