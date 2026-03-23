package ejeArrayList.eje01;

public class Coche {
	// Definir los atributos
	private String modelo; // Una cadena con el modelo de vehículo.
	private boolean motor; // Arrancado o parado ( true / false)
	private int velocidad; // velocidad en km/h
	private int velocidadMax; // Máxima velocidad con la que puede circular el vehículo
	public int distanciaParcial;
	public int distanciaTotal;
	// Definir los métodos

	// Constructor
	Coche(String modelo, int velocidadMax) {
		this.modelo = modelo;
		this.distanciaParcial = 0;
		this.distanciaTotal = 0;
		this.velocidad = 0;
		this.velocidadMax = velocidadMax;
		this.motor = false;
	}

	// Arranca el motor
	public boolean arrancar() {
		if (motor) {
			infoError("Motor ya arrancado");
			return false;
		} else {
			motor = true;
			return true;
		}
	}

	// Para el motor
	public boolean parar() {
		if (!motor) {
			infoError("Motor ya esta parado");
			return false;
		}
		if (velocidad != 0) {
			infoError("No se puede parar con el vehiculo en marcha");
			return false;
		}

		motor = false;
		distanciaParcial = 0;

		return true;

	}

	// Acelera, incrementa la velocidad
	public boolean acelera(int cantidad) {
		if (motor) {
			velocidad = velocidad + cantidad;
			// Control de la velocidad Máxima
			if (velocidad > velocidadMax) {
				velocidad = velocidadMax;
			}
			return true;
		} else {
			infoError(" Motor parado. No se puede acelerar");
			return false;
		}
	}

	// Frena, reduce la velocidad
	public boolean frena(int cantidad) {
		if (motor) {
			velocidad = velocidad - cantidad;
			// Control de la velocidad Mínima 0
			if (velocidad < 0) {
				velocidad = 0;
			}
			return true;
		} else {
			infoError(" Motor parado. No se puede frenar");
			return false;
		}
	}

	// Incrementa la distancia en función de la velocidad
	public boolean recorre() {
		if (motor) {
			// Incremento la velocidad
			distanciaParcial += velocidad;
			distanciaTotal += velocidad;
			return true;
		} else {
			infoError(" Motor parado. No se puede avanzar ");
			return false;
		}
	}

	// Información completa del coche
	public String info() {
		return this.modelo + " Motor encendido: " + motor + " km :" + distanciaParcial + " Velocidad:" + velocidad;
	}


	// Devuelve la distancia recorrida hasta ahora
	public int getKilometros() {
		return distanciaParcial;
	}

	// Muestra un mensaje por la salida estándar de errores
	private void infoError(String mensaje) {
		System.err.println(mensaje);
	}

	public String getModelo() {
		
		return this.modelo;
	}
}



