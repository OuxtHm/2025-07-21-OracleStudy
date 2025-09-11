package com.sist.manager;

import javax.print.attribute.DocAttributeSet;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FoodDataCollection {
	// food 수집
	// genie / melon 
	// recipe / chef
	// 서울 여행 / 부산 여행
	// 위키북스
	
	public void foodCollection()
	{
		try
		{
			for(int i = 1; i <= 346; i++)
			{
				Document doc = Jsoup.connect("https://www.menupan.com/restaurant/bestrest/bestrest.asp?page=" + i + "&trec=8630&pt=rt").get();
				Elements link = doc.select("p.listName span.restName a");
				for(int j = 0; j < link.size(); j++)
				{
					try {
						String url = "https://www.menupan.com" + link.get(j).attr("href");
						Document doc2 = Jsoup.connect(url).get();
						
						Element name = doc2.selectFirst("div.areaBasic dd.name");
						//System.out.println(name.text());
						String strName = name.text();
						int n = strName.indexOf("[");
						if(n >= 0)
						{
							strName = strName.substring(0, strName.indexOf("["));
						}
						System.out.println("업체명: " + strName.trim());
						
						Element type = doc2.selectFirst("div.areaBasic dd.type");
						System.out.println("업종: " + type.text());
						
						Element phone = doc2.selectFirst("div.areaBasic dd.tel1");
						System.out.println("전화번호: " + phone.text());
						
						Element address = doc2.selectFirst("div.areaBasic dd.add1");
						System.out.println("주소: " + address.text());
						
						Element score = doc2.selectFirst("div.areaBasic p.score span.total");
						System.out.println("평점: " + score.text());
						
						Element theme = doc2.selectFirst("div.areaBasic dd.theme");
						System.out.println("테마: " + theme.text());
						
						Element price = doc2.selectFirst("div.areaBasic p.price");
						System.out.println("가격대: " + price.text());
						
						Element time = doc2.selectFirst("div.infoTable ul.tableTopA dd.txt2");
						System.out.println("영업시간: " + time.text());
					} catch (Exception e) {}
					
					
					
								
				}
			}
		}catch(Exception e) {}
			
	}
	public static void main(String[] args) {
	    FoodDataCollection collector = new FoodDataCollection();
	    collector.foodCollection();
	}
}

