package kr.co.ymtech;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.NumberFormat;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class ApacheTikaExampleApplication {

	public static void main(String[] args) throws IOException, SAXException, TikaException {
//		File file = new File("C:\\Users\\MJYoun\\Pictures\\12109040.png");
//		File file = new File("C:\\Users\\MJYoun\\Downloads\\consul_1.4.4_linux_amd64.zip");
//		File file = new File("C:\\Users\\MJYoun\\Downloads\\RDP_교육자료_등록_검색_데이터플로우_윤명준_v1.1.pptx");
//		File file = new File("C:\\Users\\MJYoun\\Downloads\\[제안요청서]국가연구데이터플랫폼-비교.pdf");
//		File file = new File("C:\\Users\\MJYoun\\Downloads\\test-output.csv");
//		File file = new File("C:\\Users\\MJYoun\\Downloads\\tests-example.xls");
//		File file = new File("D:\\00.프로젝트\\02.RDP\\2차년도\\00.제안서\\00.작년 자료\\112 I. 사업수행계획 부문(28-97)_GD최종완료(69).pptx");
		File file = new File("D:\\00.프로젝트\\01.NAuth\\02.2차년도\\00.계약서\\NWAuth-기업망-LG문서\\NW 인증 정보 관리 시스템-IPTV 및 070 정보 연동 추가.zip");
		
		Parser parser = new AutoDetectParser();
		BodyContentHandler handler = new BodyContentHandler(-1);
		Metadata metadata = new Metadata();
		FileInputStream fis = new FileInputStream(file);
		ParseContext context = new ParseContext();
		
		long startTime = System.currentTimeMillis();
		parser.parse(fis, handler, metadata, context);
		long endTime = System.currentTimeMillis();
		
		System.out.println("============== " + file.getName() + " ==============");
		System.out.println("|| time: " + NumberFormat.getInstance().format(endTime-startTime) + " ms");
		System.out.println("|| size: " + NumberFormat.getInstance().format(file.length()) + " bytes");
		System.out.println("|| length: " + NumberFormat.getInstance().format(handler.toString().length()));
		System.out.println();
		
		System.out.println(" >>> handler");
		System.out.println(handler.toString().trim());
		
		String[] metadataNames = metadata.names();

		System.out.println("============== " + file.getName() + " ==============");
		System.out.println("|| time: " + NumberFormat.getInstance().format(endTime-startTime) + " ms");
		System.out.println("|| size: " + NumberFormat.getInstance().format(file.length()) + " bytes");
		System.out.println("|| length: " + NumberFormat.getInstance().format(handler.toString().length()));
		System.out.println();
		
		System.out.println(" >>> metadata");
		
		for (String name : metadataNames) {
			System.out.println(name + " :  " + metadata.get(name));
		}
	}

}
