/*
 * Oscar Primitivo
 * cs160 Spring 2022
 * Project 2: Exam Grades
 * This code is used to find max, min, amount of each grade, and more.
 */



import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExamStats {

static int letterGradeA = 90;
static int letterGradeB = 80;
static int letterGradeC = 70;
static int letterGradeD = 60;
static int letterGradeF = 0;
	public static void main(String[] args) {
		
		DecimalFormat decForm = new DecimalFormat("#.##");
			int countA = 0;
			int countB = 0;
			int countC = 0;
			int countD = 0;
			int countF = 0;
				float totalExamCount = 0;
				int sumExamCount = 0;
				float averageScore = 0;
				float difference = 0;
				float standardDeviation = 0;
				
			boolean Score1 = true;
			boolean Score2 = true;
					int score1 = 0;
					int score2 = 0;
					int maxScore = 0;
					int minScore = 0;
			
		Scanner keyboard = new Scanner(System.in);
		System.out.println("what is the name of the file?");
		String nameOfFile = keyboard.next();
		
		
		while (Score1 ==true) {
			
		Scanner userInput = null;
		
		try {
			userInput = new Scanner (new File(nameOfFile));
			while (userInput.hasNextInt()) {
				int num = userInput.nextInt();
					if (num <= 100 && num >= 0) {
						if (num >= letterGradeA) {
							totalExamCount += 1;
							countA += 1;
							score1 = num;
							score2 = num;
							sumExamCount += num;
							
						}else if (num >= letterGradeB) {
							totalExamCount += 1;
							countB += 1;
							score1 =num;
							score2 =num;
							sumExamCount += num;
							
						}else if (num >= letterGradeC) {
							totalExamCount += 1;
							countC += 1;
							score1 =num;
							score2 =num;
							sumExamCount += num;
							
						}else if (num >= letterGradeD) {
							totalExamCount += 1;
							countD += 1;
							score1 =num;
							score2 =num;
							sumExamCount += num;
							
						}else if (num >= letterGradeF) {
							totalExamCount += 1;
							countF += 1;
							score1 =num;
							score2 =num;
							sumExamCount += num; 
			
						}
						
					if (score1 > maxScore) {
						maxScore = score2;
					}
					
					if (score2 <minScore) {
						minScore = score2;
					}
				}		
					averageScore = sumExamCount/totalExamCount;
			}
				Score1 = false;
		}
			catch (Exception ex) {
				System.out.println("File not found, retry file name");
				
			}
		}
			while (Score2 == true) {
					Scanner userInput2 = null;
						try {
							userInput2 = new Scanner(new File(nameOfFile));
							while (userInput2.hasNextInt()) {
								int num2 = userInput2.nextInt();
								if (num2 <= 100 && num2 >= 0) {
									difference = averageScore - num2;
									standardDeviation += Math.pow(difference, 2);
								}
							}
								Score2 = false;
						} catch (Exception ex)	{
							
						}
				}
			standardDeviation = standardDeviation/totalExamCount;	
			standardDeviation = (float) Math.sqrt(standardDeviation);
			try {
				File finalGrades = new File ("FinalGrades.txt");
				FileWriter outWrite = new FileWriter(finalGrades);
				outWrite.write("Exam Stats" + "\n\nNumber of Scores: " + totalExamCount + "\nAverage Score: " + decForm.format(averageScore) + "\nStandard Deviation: "
						+decForm.format(standardDeviation) + "\n\nA Count: " + "\t" + decForm.format((countA/totalExamCount)*100) + "%" + "\nB Count: "
						+ countB + "\t" + decForm.format((countB/totalExamCount)*100) + "%" + "\nC Count: " + countC + "\t" + decForm.format((countC/totalExamCount)*100)
						+ "%" + "nD Count: " + countD + "\t" + decForm.format((countD/totalExamCount)*100) + "%" + "\nF Count: " + countF + "\t" 
						+ decForm.format((countF/totalExamCount)*100) + "%" + "\n\nMinimum Score: " + minScore + "\nMaximum Score " + maxScore); outWrite.close();
			} catch (Exception ex) {
				
			}
			
		System.out.println("Exam Stats" + "\n\nNumber of Scores: " + totalExamCount + "\nAverage Score: " + decForm.format(averageScore) + "\nStandard Deviation: "
						+decForm.format(standardDeviation) + "\n\nA Count: " + "\t" + decForm.format((countA/totalExamCount)*100) + "%" + "\nB Count: "
						+ countB + "\t" + decForm.format((countB/totalExamCount)*100) + "%" + "\nC Count: " + countC + "\t" + decForm.format((countC/totalExamCount)*100)
						+ "%" + "nD Count: " + countD + "\t" + decForm.format((countD/totalExamCount)*100) + "%" + "\nF Count: " + countF + "\t" 
						+ decForm.format((countF/totalExamCount)*100) + "%" + "\n\nMinimum Score: " + minScore + "\nMaximum Score " + maxScore);
		 }
}
