class Esempi_Esame_Es3 {

static boolean e3R(boolean[] a, int i) {
   //c.i.: a != null, i < a.length
	//c.u.: restituisce true se e solo se i valori true e false in a si 
	//alternano
	 if (i < a.length - 1) 
	 	 return e3R(a,i + 1) && (a[i] != a[i + 1]);
	 else return true;
	 }

/***
La formulazione precisa della condizione di uscita è la seguente:

   per ogni a != null e i < a.length 
      [e3R(a,i) == true se e solo se per ogni j >= i ( se j < a.length - 1 allora a[j] != a[j + 1] ) ]

	Abbreviamo con P(i) la proposizione:
	
	e3R(a,i) == true se e solo se per ogni j >= i ( se j < a.length - 1 allora a[j] != a[j + 1] ) 
	
Dimostriamo P(i) per induzione su a.length - i.

Base: a.length - i == 1, cioè i == a.length - 1. Non ci sono j >= i che 
siano anche < a.length - 1, quindi la condizione di uscita è vera a vuoto.
	 
Passo induttivo: assumiamo (ipotesi induttiva) che P(i + 1), cioè

e3R(a,i + 1) == true se e solo se per ogni j >= i + 1 ( se j < a.length - 1 allora a[j] != a[j + 1] ) 

Bisogna dimostrare che P(i), cioè:

e3R(a,i) == true se e solo se per ogni j >= i ( se j < a.length - 1 allora a[j] != a[j + 1] ) 
	 
Ci sono due casi:
 
e3R(a,i) == true: allora e3R(a,i+1) == true e a[i] != a[i + 1] e P(i) è 
vera, per ipotesi induttiva e per come è fatto il metodo;
e3R(a,i) == false: in questo caso 
	 
    a[i] == a[i + 1], oppure
	 e3R(a,i + 1) == restituisce false
	 
per ipotesi induttiva e per come è fatto il metodo, e in entrambi i casi non è vero che 

per ogni j >= i ( se j < a.length - 1 allora a[j] != a[j + 1] ) 

quindi vale l'equivalenza P(i).

***/
static boolean wrap_e3R(boolean [] a){
    return e3R(a,0);
}

static boolean e3I(boolean [] a) {
	 //c.i.: a != null
	 //c.u.: e3I(a) restituisce true se e solo se i valori true e false in a si alternano
	 int i = 0;
	 boolean r = true;
	 while (i < a.length - 1) {  // invariante: r == true se e solo se per ogni j < i (a[j] != a[j + 1]) 
	    r = r && a[i] != a[i + 1];
		 i++;
	 }
	 return r;
}

/***
Formulazione precisa della condizione di uscita:

   per ogni a != null
      [r == true se e solo se per ogni i < a.length - 1 (a[i] != a[i + 1] ) ]

Abbreviamo con P la proposizione:
	
	r == true se e solo se per ogni j < i (a[j] != a[j + 1]) 

per induzione sul numero k >= 0 di iterazioni del corpo del ciclo while, 
si dimostra che P è invariante, cioè

dopo k iterazioni (r == true se e solo se per ogni j < i - 1 (a[j] != a[j + 1])) 

Base: dopo 0 iterazioni: i == 0 e r == true, e non ci sono j < i == 0 che 
soddisfano la condizione.

Passo induttivo: SE

dopo k iterazioni (r == true se e solo se per ogni j < i (a[j] != a[j + 1]))

ALLORA

dopo k + 1 iterazioni (r == true se e solo se per ogni j < i (a[j] != a[j + 1]))

Considerare i casi possibili relativamente a:

per r' ci sono due casi:

r' == true, cioè r && a[i] != a[i + 1] == true. Per ipotesi induttiva 
 
   per ogni j < i (a[j] != a[j + 1])

e, per come è fatto il metodo anche a[i] != a[i + 1] == true, quindi, 
osservando che i' = i + 1:

   per ogni j < i + 1 (a[j] != a[j + 1]) 

Quindi P è invariante. All'uscita dal metodo i == a.length - 1 e per 
l'invariante r == true se e solo se per ogni j < i (a[j] != a[j + 1])
abbiamo che 

r == true se e solo se per ogni i < a.length - 1 (a[i] != a[i + 1] ),

cioè i valori booleani in a si alternano.
	
***/

public static void main(String [] args){
    boolean [] a = {true,false,true,false};
    System.out.println(wrap_e3R(a));
    System.out.println(e3I(a));
}
}

