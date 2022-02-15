package dam.prog.actividadUF7_3.ej2.pojo;

public class Cancion {
	
	public static final int MIN_DURATION = 10;
	public static final int MAX_DURATION = 10;
	
	private String title;
	private String creator;
	private int duration;
	
	public Cancion(String title, String creator, int duration) {
		this.setTitle(title);
		this.setCreator(creator);
		this.setDuration(duration);
	}
	
	// SETTERS
	public void setTitle(String title) {
		if (title == null) {
			throw new InvalidDataException(
				"El título no puede ser null."
			);
		}
		this.title = title;
	}
	
	public void setCreator(String creator) {
		if (creator == null) {
			throw new InvalidDataException(
				"El artista/grupo no puede ser null."
			);
		}
		this.creator = creator;
	}
	
	private void setDuration(int duration) {
		if (duration < MIN_DURATION || duration > MAX_DURATION)
		{
			throw new InvalidDataException(
				"La duración de la canción tiene que estar en el intervalo",
				MIN_DURATION,
				MAX_DURATION
			);
		}
		this.duration = duration;
	}
	
	//GETTERS
	public String getTitle() {
		return title;
	}
	
	public String getCreator() {
		return creator;
	}
	
	public int getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		return String.format("{Título: %s, artista/grupo: %s, duración: %ds}", title, creator, duration);
	}
}
