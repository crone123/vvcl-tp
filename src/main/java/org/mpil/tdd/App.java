package org.mpil.tdd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class App {
	public Double montantTotal(Integer... integers) {
		double total = 0.0;
		ArrayList<ArrayList<Integer>> listes = new ArrayList<ArrayList<Integer>>();
		/*
		DEBUG
		System.out.println("IN:");
		for(int i : integers)
		{
			System.out.print(i + ", ");
		}
		System.out.println();
		*/
		for(int i : integers)
		{
			int liste_index = 0;
			while(liste_index < listes.size() && listes.get(liste_index).contains(i))
			{
				liste_index += 1;
			}
			if(liste_index == listes.size())
			{
				listes.add(new ArrayList<Integer>());
			}
			listes.get(liste_index).add(i);
		}
		/*
		DEBUG
		System.out.println("OUT:");
		System.out.println(listes);*/
		for(ArrayList<Integer> liste : listes)
		{
			double coef = 1.0;
			switch(liste.size())
			{
				case 2:
					coef = 0.95;
					break;
				case 3:
					coef = 0.90;
					break;
				case 4:
					coef = 0.80;
					break;
				case 5:
					coef = 0.75;
					break;
			}
			total += liste.size() * 8 * coef;
		}
		return total;
	}

}
