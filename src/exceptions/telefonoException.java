package exceptions;

public class telefonoException extends Exception{
		public telefonoException()
		{
			
		}

		@Override
		public String getMessage() {

			return "El tel�fono no puede contener letras, s�lo numeros!";
		}
		
		
}
