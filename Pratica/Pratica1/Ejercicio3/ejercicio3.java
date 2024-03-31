package ejercicio3;

public class tp1.ejercicio3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Estudiante[] estudiantes = new Estudiante[2];
		Profesor[] profesores = new Profesor[3];
		
		estudiantes[0] = new Estudiante("Jose","Perez",5,"joseperez@hotmail.com","Buenos Aires 123");
		estudiantes[1] = new Estudiante("Pepito","Perez",2,"pepitoperez@hotmail.com","Buenos Aires 122");
		
		profesores[0] = new Profesor("Mariano","Lopez","MarianoLopez@hotmail.com",'A',"Informatica");
		profesores[1] = new Profesor("Mariano","Cruz","MarianoCruz@hotmail.com",'A',"Psicologia");
		profesores[2] = new Profesor("Jose","Lopez","JoseLopez@hotmail.com",'C',"Informatica");
		
		for(Estudiante est: estudiantes) {
			System.out.println(est.tusDatos());
		}
		
		for(Profesor prof: profesores) {
			System.out.println(prof.tusDatos());
		}
	}

}
