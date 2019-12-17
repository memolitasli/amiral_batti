package amiral_batti;

import java.util.Random;
import java.util.Scanner;

// Mehmet Taþlý amiral battý oyunu
public class MainClass {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Random rnd = new Random();
	int x1,x2,x3,y1,y2,y3,kontrol = 0,tempx,tempy;
	int skor =0,dusman_skor = 0;
	int[][] matris = new int[5][5]; // matris adli int türünde bir matris olusturdum
	for (int i = 0; i < 5; i++) {// baslangicta matrisimin tüm elemanlarýný 1 yaptým kullanýcý atýþ yaptýðý zaman 
		// eðer düþmaný vurursa 0 olacak
		for (int j = 0; j < 5; j++) {
			matris[i][j] = 1;
		}
	}
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			System.out.print(" [ " +matris[i][j]+ " ] ");
		}
		System.out.println("\n");
	}
	System.out.println("gemilerinizi yerlestirdiginiz yerler 2 olarak gözükecek...");
	int q = 1;
	while(true) {
		int x,y;
		System.out.println(q+ " . geminizi yerlestirmek istediginiz yerin X kordinatini giriniz : ");
		x = sc.nextInt();
		System.out.println(q+ " . geminizi yerlestirmek istediginiz yerin Y kordinatini giriniz : ");
		y = sc.nextInt();
		if(matris[x][y] == 0 || x<4 || y<4) {
		matris[x][y] = 2;
		q++;
		}
		else {
			System.out.println("girdiginiz kordinat daha onceden girmissiniz lutfen tekrar giriniz...\n ve girdi"
					+ "giniz kordinatlarin 0 - 4 arasinda olmasina dikkat ediniz...");
		}
		if(q >3)
		{
			break;
		}
		
	}
	
		// bilgisayarýn gemilerini yerleþtirecegi konumlarý random komutu ile ekliyorum
		x1 = rnd.nextInt(4);
		x2 = rnd.nextInt(4);
		x3 = rnd.nextInt(4);
		y1 = rnd.nextInt(4);
		y2 = rnd.nextInt(4);
		y3 = rnd.nextInt(4);
		
		
	while(true) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(" [ " +matris[i][j]+ " ] ");
			}
			System.out.println("\n");
		}
		if(kontrol == 0) { // sira oyuncuda
			System.out.println("atis yapmak istediginiz noktanin x kordinatini giriniz : ");
			tempx = sc.nextInt();
			System.out.println("atis yapmak istediginiz noktanin y kordinatini giriniz : ");
			tempy = sc.nextInt();
			
			if((tempx == x1 && tempy == y1) || (tempx == x2 && tempy == y2) || (tempx == x3 && tempy == y3))
			{
				System.out.println("Atis basarili vurulan nokta 0 ile degistiriliyor...");
				matris[tempx][tempy] = 0;
				skor = skor + 10;
			}
			else {
				System.out.println("hatali atis yapildi...");
			}
			kontrol = 1;
		}
		else { // sira bilgisayarda
			tempx = rnd.nextInt(4);
			tempy = rnd.nextInt(4);
			if(matris[tempx][tempy] == 1) {
				System.out.println("düþman birlikleri geminizi vurdu...");
				matris[tempx][tempy] = 0;
				dusman_skor = dusman_skor + 10;
			}
			else {
				System.out.println("düþman geminizi iskaladi...");
			}
			kontrol = 0;
		}
		if(skor == 30 || dusman_skor == 30) {
			System.out.println("oyun bitti. Kazanan : ");
			if(skor == 30) {
				System.out.println("Sensin ...\n Tebrikler komutanim düþmanýn anasýný siktin...");
				System.out.println("puanýn : " + skor);
			}
			else if(dusman_skor == 30) {
				System.out.println("Düþman birlikleri... Puanýn : " + skor);
			}
			break;
		}
		
	}
	System.out.println("oyun sona erdi...");
	
	}

}
