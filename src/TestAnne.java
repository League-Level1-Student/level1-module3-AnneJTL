import java.util.Arrays;


public class TestAnne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] tableau = {0,1,2,3,4,5,6,7,8,9};
		System.out.println("tableau: " + toIdentityString(tableau) + " valeur: " + Arrays.toString(tableau));

		
		modifieTableau(tableau);
		System.out.println("tableau: " + toIdentityString(tableau) + " valeur: " + Arrays.toString(tableau));

		
		/*
		String inMain = new String("inMain");
		System.out.println("inMain avant: " + toIdentityString(inMain) + " valeur: " + inMain);
		
		String retour = modifieString(inMain);
		
		System.out.println("inMain apres: " + toIdentityString(inMain) + " valeur: " + inMain);
		System.out.println("retour: " + toIdentityString(retour) + " valeur: " + retour);

*/
	}

	public static void modifieTableau(int[] parameterTab) {
		System.out.println("parameterTab: " + toIdentityString(parameterTab) + " valeur: " + Arrays.toString(parameterTab));
		parameterTab[4] = 1500;
		System.out.println("parameterTab: " + toIdentityString(parameterTab) + " valeur: " + Arrays.toString(parameterTab));

		
	}
	public static String modifieString(String parametre){
		System.out.println("modifieString parametre: " + toIdentityString(parametre) + " valeur: " + parametre);
		parametre += "abc";
		System.out.println("modifieString parametre: " + toIdentityString(parametre) + " valeur: " + parametre);

		String valeur = parametre.substring(2, 3);
		System.out.println("modifieString valeur: " + toIdentityString(valeur) + " valeur: " + valeur);

		return valeur;
	}
	
    public static String toIdentityString(Object o) {
        if (o==null) {
            return "null";
        }
        return o.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(o));
    }
}
