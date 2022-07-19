package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
// op.gg 챔피언 분석 포지션별로 출력하기
public class Crawling {
	public static void main(String[] args) {
		final String url1 = "https://www.op.gg/champions?region=kr&tier=platinum_plus&position=top";
		final String url2 = "https://www.op.gg/champions?region=kr&tier=platinum_plus&position=jungle";
		final String url3 = "https://www.op.gg/champions?region=kr&tier=platinum_plus&position=mid";
		final String url4 = "https://www.op.gg/champions?region=kr&tier=platinum_plus&position=adc";
		final String url5 = "https://www.op.gg/champions?region=kr&tier=platinum_plus&position=support";
		Document doc = null;
		Scanner sc= new Scanner(System.in);
		while(true) {
			try {
				System.out.println("1.탑 2.정글 3.미드 4.원딜 5.서포터");
				System.out.print("숫자를 입력해주세요: ");
				int num=sc.nextInt();
				if(num==1) {
					doc=Jsoup.connect(url1).get();
				}else if(num==2) {
					doc=Jsoup.connect(url2).get();			
				}else if(num==3) {
					doc=Jsoup.connect(url3).get();
				}else if(num==4) {
					doc=Jsoup.connect(url4).get();			
				}else if(num==5) {
					doc=Jsoup.connect(url5).get();			
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements e1=doc.select(".css-cym2o0.e1oulx2j6");
			Elements e2=doc.select(".css-ew1afn.e1oulx2j3");
			Elements e3=doc.select(".css-1wvfkid.exo2f211");
			Iterator<Element> itr1 = e1.iterator();
			Iterator<Element> itr2 = e2.iterator();
			Iterator<Element> itr3 = e3.iterator();
			System.out.println("==============================================================");
			while(itr3.hasNext()) {
				String str1=itr1.next().text();
				String str2=itr2.next().text();
				String str3=itr3.next().text();
				String str4=itr3.next().text();
				String str5=itr3.next().text();

				System.out.print("챔피언: "+str1);
				System.out.print(" 티어: "+str2);
				System.out.print(" 승률: "+str3);
				System.out.print(" 픽률: "+str4);
				System.out.println(" 밴률: "+str5);
			}
			System.out.println("==============================================================");
			System.out.println("1.종료 2.다시");
			System.out.print("숫자를 입력해주세요: ");
			int num=sc.nextInt();
			if(num==1) {
				break;
			}
			continue;
		}
	}
}	
