package qrcodetest;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
public class BlackAndWhiteTest {
	public static void main(String[] args) throws IOException {
/		
		try {
			String str = fromQRCode("/Users/Documents/eclipseworkspace/QRCodeTest/src/qrcodetestt/code1.png");
			System.out.print(str);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;

	private static void toQRCode(String inFileString, String outFileString) throws WriterException, IOException {
		String base64 = new String(toBase64(inFileString));
		QRCodeWriter barcodeWriter = new QRCodeWriter();
		BitMatrix matrix = barcodeWriter.encode(base64, BarcodeFormat.QR_CODE, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	    MatrixToImageWriter.writeToFile(matrix, "png", new File(outFileString));
	}

	private static void fromQRCode(String inFileString, String outFileString) throws IOException, NotFoundException {
		BufferedImage image;
	      image = ImageIO.read(new File(inFileString));
	    if (image != null) {
	      
	    LuminanceSource source = new BufferedImageLuminanceSource(image);
	    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
	    Result result = new MultiFormatReader().decode(bitmap);
	    String base64 =  String.valueOf(result.getText());
		fromBase64(outFileString, base64);
	    }
	}
	
	private static String fromQRCode(String inFileString) throws IOException, NotFoundException {
		BufferedImage image;
	      image = ImageIO.read(new File(inFileString));
	    if (image != null) {
	      
	    LuminanceSource source = new BufferedImageLuminanceSource(image);
	    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
	    Result result = new MultiFormatReader().decode(bitmap);
	    return  String.valueOf(result.getText());
		
	    }
	    return null;
	}
	
	private static void toBlackAndWhiteImgFile(String from, String to) throws IOException{
		File file = new File(from);
	    BufferedImage orginalImage = ImageIO.read(file);

	    BufferedImage blackAndWhiteImg = new BufferedImage(
	        orginalImage.getWidth(), orginalImage.getHeight(),
	        BufferedImage.TYPE_BYTE_BINARY);
	    
	    Graphics2D graphics = blackAndWhiteImg.createGraphics();
	    graphics.drawImage(orginalImage, 0, 0, null);

	    ImageIO.write(blackAndWhiteImg, "png", new File(to)); 
	}
	
	private static byte[] toBase64(String fname) throws IOException{
		File file = new File(fname);
	    BufferedImage orginalImage = ImageIO.read(file);
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( orginalImage, "png", baos );
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		byte[] encoded = Base64.encodeBase64(imageInByte);     
	    return encoded;
	}
	
	private static void fromBase64(String fname, String encoded) throws IOException{
		 byte[] decoded = Base64.decodeBase64(encoded); 
		 InputStream in = new ByteArrayInputStream(decoded);
		 BufferedImage image = ImageIO.read(in);
		 ImageIO.write(image, "png", new File(fname)); 
	}
	
}
