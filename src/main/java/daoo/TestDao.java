package daoo;

import java.util.List;

import metier.entities.Livre;
public class TestDao {
public static void main(String[] args) {
LivreDaoImpl pdao= new LivreDaoImpl();
Livre liv= pdao.save(new Livre("iphone 8 plus","aaa",2800,200,null));
System.out.println(liv);
List<Livre> livs =pdao.livresParMC("Ca");
for (Livre l : livs)
System.out.println(l);
}
}