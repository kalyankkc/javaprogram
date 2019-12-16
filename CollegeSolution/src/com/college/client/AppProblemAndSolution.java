package com.college.client;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.college.entity.Category;
import com.college.entity.Problem;
import com.college.entity.Solution;
import com.college.service.serviceimpl.CollegeServiceImpl;

public class AppProblemAndSolution {
	static CollegeServiceImpl objs = new CollegeServiceImpl();
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		boolean chk = start();
		if (chk == true)
			System.out.println("******THANK YOU******");

	}

	private static Set<Category> getCategoryFromSer() {
		Set<Category> result = new HashSet<>();
		result = objs.getCategoryFromDao();
		return result;
	}

	private static Set<Problem> getProblemFromSer() {
		Set<Problem> result = new HashSet<>();
		result = objs.getProblemFromDao();
		return result;
	}

	private static boolean start() {
		Set<Category> category = new HashSet<>();
		Set<Problem> problem = new HashSet<>();
		Set<Solution> solution = new HashSet<>();
		boolean repeat = true;

		do {
			System.out.println("Enter 1 to Add Solution");
			System.out.println("Enter 2 to assign category for problem");
			System.out.println("Enter 3 to assign solution for problem");
			System.out.println("Enter 4 to display problems by catagory");
			System.out.println("Enter 5 to display problems by solution");
			System.out.println("Enter 6 to  exit");
			int n = input.nextInt();
			switch (n) {
			case 1:
				for (int i = 0; i < 4; i++) {
					System.out.println("Enter Solution ID");
					int id = input.nextInt();
					System.out.println("Enter Solution description");
					String des = input.next();
					Solution sol = new Solution(id, des);
					solution.add(sol);
				}
				objs.setSolutioninDao(solution);

				break;
			case 2:
				category = getCategoryFromSer();
				problem = getProblemFromSer();
				for (Problem problem2 : problem) {
					System.out.println("Enter category for " + problem2.getProbName() + " Problem");
					problem2.setCategory(input.next());
				}

				for (Category catagory2 : category) {
					Set<Problem> pro = new HashSet<>();
					for (Problem problem2 : problem) {
						if (catagory2.getCategoryName().equals(problem2.getCategory())) {
							pro.add(problem2);
							catagory2.setProblem(pro);
						}
					}
				}

				break;
			case 3:

				for (Problem prob : problem) {
					System.out.println("Enter Solution for " + prob.getProbName() + " Problem");
					String s = input.next();
					prob.setSolution(s);
				}
				for (Solution sol2 : solution) {
					Set<Problem> pro = new HashSet<>();
					for (Problem problem2 : problem) {
						if (sol2.getSolutionDescription().equals(problem2.getCategory())) {
							pro.add(problem2);
							sol2.getProbsol();
						}
					}
				}
				break;

			case 4:
				System.out.println("Enter catagory");
				String cat = input.next();
				for (Category c : category) {
					if (c.getCategoryName().equals(cat)) {
						Set<Problem> p = c.getProblem();
						for (Problem res : p) {
							System.out.println(res.getProbId());
							System.out.println(res.getProbName());
							System.out.println(res.getProbDescription());
						}

					}
				}
				break;
			case 5:
				System.out.println("Enter solution");
				String sol = input.next();
				for (Solution s : solution) {
					if (s.getSolutionDescription().equals(sol)) {
						Set<Problem> p = s.getProbsol();
						for (Problem res : p) {
							System.out.println(res.getProbId());
							System.out.println(res.getProbName());
							System.out.println(res.getProbDescription());
						}

					}
				}
				break;
			case 6:
				repeat = false;
			}

		} while (repeat);
		return true;
	}
}
