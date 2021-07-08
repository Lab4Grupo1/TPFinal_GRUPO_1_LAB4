package exceptions;

public class telefonoException extends Exception{
		public telefonoException()
		{
			
		}

		@Override
		public String getMessage() {

			return "El teléfono no puede contener letras, sólo numeros!";
		}
		
		
}
