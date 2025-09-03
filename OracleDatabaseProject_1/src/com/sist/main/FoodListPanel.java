package com.sist.main;

import java.awt.*;
import javax.swing.*;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.List;
import java.net.*;

public class FoodListPanel extends JPanel{
	JPanel pan = new JPanel();
	JButton b1, b2; 
	JLabel la = new JLabel("0 page / 0 pages");
	JLabel[] imags = new JLabel[20];
	
	int curpage = 1;
	int totalpage = 0;
	
	FoodDAO dao = FoodDAO.newInstance();
	
	public FoodListPanel()
	{
		setLayout(null);
		pan.setLayout(new GridLayout(4, 5, 5, 5));
		pan.setBounds(20, 15, 770, 580);
		add(pan);
		
		b1 = new JButton("이전");
		b2 = new JButton("다음");
		
		JPanel p = new JPanel();
		p.add(b1);
		p.add(la);
		p.add(b2);
		p.setBounds(20, 605, 770, 35);
		add(p);
		
		print();
	}
	public void init()
	{
		for(int i = 0; i < imags.length; i++)
		{
			imags[i] = new JLabel("");
		}
		pan.removeAll();	// panel 에 있는 모든 컴포넌트 제거
		pan.validate();		// panel 재배치
	}
	public void print()
	{
		totalpage = dao.foodTotalPage();
		List<FoodVO> list = dao.foodListData(curpage);
		
		for(int i = 0; i < imags.length; i++)
		{
			FoodVO vo = list.get(i);
			try {
				URL url = new URL(vo.getPoster());
				Image img = ImageChange.getImage(new ImageIcon(url), 140, 150);
				imags[i] = new JLabel(new ImageIcon(img));
				imags[i].setToolTipText(vo.getName());
				pan.add(imags[i]);
			} catch (Exception e) {}
		}
		la.setText(curpage +" page / " + totalpage + " pages");
	}
	
}
