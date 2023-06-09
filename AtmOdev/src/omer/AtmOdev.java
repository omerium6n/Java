package omer;

import java.util.Scanner;

public class AtmOdev {

	static Scanner sc = new Scanner(System.in);
	static double yatirilanPara = 0;
	static double hesaptakiPara = 100;
	static double guncelHesap = 0;
	static double cekilecekPara = 0;
	static double krKontrol = 0;
	static int secenek;
	static double cekilenKredi, yatirilanKredi, krediBorcu;
	static double cekilebilecekKredi = 0;

	public static void main(String[] args) {

		// Tek Kullanıcılı Giriş Adı: 37651107796
		// Şifre :1905

		usersData();

		menu();

	}

	public static void menu() {

		while (hesaptakiPara > -1) {

			System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçin\n");

			System.out.println("(1) Bakiye Sorgulama");

			System.out.println("(2) Para Çekme");

			System.out.println("(3) Para Yatırma");

			System.out.println("(4) Kredi Borcu Ödeme");

			System.out.println("(5) Kredi Çekme");

			System.out.println("(6) Çıkış");

			secenek = getOption();

			kontrol(secenek);

			break;
		}

	}

	public static String usersData() {

		String kullanici = "37651107796";

		String pw = "1905";

		String ıD;

		String password;

		System.out.println("Kullanıcı Numaranızı Giriniz");

		ıD = sc.next();

		System.out.println("Şifrenizi Giriniz");

		password = sc.next();

		if (ıD.equals("37651107796") && password.equals("1905")) {

			System.out.println("Girişiniz Başarılı\n");

		} else {

			System.out.println("Eksik yada Hatalı Giriş yaptınız!");

			usersData();

		}

		return kullanici + pw;

	}

	public static int getOption() {

		int option = sc.nextInt();

		return option;

	}

	public static void kontrol(int secenek) {

		if (secenek == 1) {

			bakiyeSorgulama();

		} else if (secenek == 2) {

			paraCekme(hesaptakiPara, cekilecekPara);

		} else if (secenek == 3) {

			paraYatir(hesaptakiPara, yatirilanPara);

		} else if (secenek == 4) {

			krediYatir(yatirilanKredi, krediBorcu);

		} else if (secenek == 5) {

			krediCek(hesaptakiPara, cekilenKredi, krediBorcu);

		} else if (secenek == 6) {

			System.out.println("Çıkış İşlemi Gerçekleştiriliyor...");

		} else {

			if (secenek > 6) {

				System.out.println("Geçerli bir işlem giriniz!\n");

				System.out.println("Ana Menüye Yönlendiriliyorsunuz...\n\n");

				menu();

			}
		}

	}

	public static double paraYatir(double a, double b) {

		System.out.println("Hesabınızda Bulunan Miktar :" + hesaptakiPara + "TL\n");

		System.out.println("Yatırmak istediğinz Miktarı giriniz :");

		yatirilanPara = sc.nextDouble();

		if (yatirilanPara == 0) {

			System.out.println("Geçerli bir Tutar Giriniz!");

			paraYatir(hesaptakiPara, yatirilanPara);

		} else if (yatirilanPara > 0) {

			hesaptakiPara += yatirilanPara;

			krKontrol = hesaptakiPara * 10;

			System.out.println(
					"Yatırma İşleminiz Başarıyla Gerçekleşmiştir \n Güncel Bakiyeniz : " + hesaptakiPara + "TL\n");
		}
		System.out.println("Ana Menüye Yönlendiriliyorsunuz...\n\n");

		menu();

		return hesaptakiPara + yatirilanPara + krKontrol;
	}

	public static double paraCekme(double a, double b) {

		System.out.println("Hesabınızda Bulunan Miktar :" + hesaptakiPara + "TL\n");

		System.out.println("Çekmek İstediğiniz Miktarı Giriniz :");

		cekilecekPara = sc.nextInt();

		if (hesaptakiPara >= cekilecekPara && cekilecekPara > 0) {

			hesaptakiPara -= cekilecekPara;

			System.out.println("Güncel Bakiyeniz: " + hesaptakiPara + "TL\n");

			System.out.println("Ana Menüye Yönlendiriliyorsunuz...\n\n");

			menu();

		} else {

			System.out.println("Eksik yada Hatalı Giriş yaptınız! \n Geçerli tutar giriniz :");

			paraCekme(hesaptakiPara, cekilecekPara);
		}

		return hesaptakiPara + krKontrol;
	}

	public static void bakiyeSorgulama() {

		System.out.println("Hesabınızda  " + hesaptakiPara + "TL " + " bulunmaktadır\n");

		System.out.println("Ana Menüye Yönlendiriliyorsunuz...\n\n");

		menu();

	}

	public static double krediCek(double a, double b, double c) {

		krKontrol = hesaptakiPara * 10;

		cekilebilecekKredi = krKontrol;

		System.out.println("Maksimum Kredi Tutarınız :" + (cekilebilecekKredi - (krediBorcu / 1.5)) + "TL'dir\n");

		if (hesaptakiPara == 0) {
			System.out.println("Kredi çekmek için Gereken Şartlar Sağlanamıyor...\n");
			menu();

		} else {
			System.out.println("Kredi çekmek istediğiniz tutarı giriniz :");

			cekilenKredi = sc.nextDouble();

			if (cekilenKredi == 0) {

				System.out.println("Hatalı Tutar Girdiniz!\n");

				krediCek(hesaptakiPara, krKontrol, cekilenKredi);

			} else if (cekilenKredi > cekilebilecekKredi) {

				System.out.println("Maksimum Kredi Miktarını Aştınız!!\n");

				krediCek(hesaptakiPara, krKontrol, cekilenKredi);

			} else {

				System.out.println("Kredi çekme işleminiz kabul edildi \n\nÇekilen Tutar :" + cekilenKredi + "TL\n");

				krediBorcu += cekilenKredi * 1.5;

				System.out.println("Ödemeniz Gereken Kredi Borcunuz : " + krediBorcu + "TL");

			}
			System.out.println("Ana Menüye Yönlendiriliyorsunuz...\n");

			menu();

		}
		return hesaptakiPara + cekilenKredi + krediBorcu;
	}

	public static double krediYatir(double a, double b) {
		

		System.out.println("Güncel Kredi Borcunuz : " + krediBorcu + "TL\n");

		System.out.println("Ödemek istediğiniz borç tutarını giriniz :");

		yatirilanKredi = sc.nextDouble();

		if (yatirilanKredi <= 0) {

			System.out.println("Geçersiz İşlem Lütfen Tekrar Giriniz!\n");

			krediYatir(krediBorcu, yatirilanPara);

		} else if (yatirilanKredi > krediBorcu) {

			yatirilanKredi -= krediBorcu;

			System.out.println("Borcunuz Kapandı Ödemeden Artan Tutar :" + yatirilanKredi + "TL\n");

			krediBorcu = 0;

			System.out.println("Ana Menüye Yönlendiriliyorsunuz...");

			menu();

		} else {

			krediBorcu -= yatirilanKredi;

			System.out.println("Ödemeniz Gerçekleşti Güncel Borcunuz :" + krediBorcu + "TL\n");

		}
		menu();

	return krediBorcu + yatirilanKredi + hesaptakiPara ;

	}
}
