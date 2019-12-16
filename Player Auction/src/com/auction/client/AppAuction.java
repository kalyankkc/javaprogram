package com.auction.client;

import java.util.Scanner;

import com.auction.entity.Player;
import com.auction.exception.serviceexception.AuctionServiceException;
import com.auction.service.serviceimpl.ActionServiceImpl;

public class AppAuction {
	static Scanner input = new Scanner(System.in);
	static ActionServiceImpl serviceImpl = new ActionServiceImpl();

	public static void main(String[] args) {

		boolean check = true;

		while (check == true) {
			System.out.println("Enter 1 to Insert Olayer with Team");
			System.out.println("Enter 2 to Insert Olayer with Team");
			int n = input.nextInt();
			switch (n) {
			case 1:
				boolean chk = false;
				Player player = InsertPlayer();
				if(player!=null) {
				try {
					chk = serviceImpl.setPlayerInDB(player);
				} catch (AuctionServiceException e) {
					System.out.println(e.getMessage());
				}
				if (chk == true)
					System.out.println("DATA INSERTED");
				}
				else
					System.out.println("INCORECT DATA"+"\n"+"ENTER AGAIN");
				break;

			}
		}

	}

	public static Player InsertPlayer() {
		Player player = new Player();
		boolean check = false;

		try {
			System.out.println("Enter Player Name");
			String name = input.next();
			System.out.println("Enter Catagory");
			String catagory = input.next();
			System.out.println("Enter Highiest Score");
			int score = input.nextInt();
			System.out.println("Enter Best Figure");
			String figure = input.next();
			System.out.println("Enter Team Name");
			String team = input.next();
			check = serviceImpl.checkPlayer(catagory, score, figure,team);
			player.setPlayerName(name);
			player.setCatagory(catagory);
			player.setHighestScore(score);
			player.setBestFigure(figure);
		} catch (AuctionServiceException e) {
			System.out.println(e.getMessage());
		}
		if(check==true)
		return player;
		else
			return null;

	}

}
