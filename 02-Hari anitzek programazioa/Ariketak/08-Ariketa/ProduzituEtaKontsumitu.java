public class ProduzituEtaKontsumitu {

	public static void main(String[] args) {
		Kola kola = new Kola();
		Produktorea p = new Produktorea(kola, 1);
		Kontsumitzailea k = new Kontsumitzailea(kola, 1);
		p.start();
		k.start();
	}
}