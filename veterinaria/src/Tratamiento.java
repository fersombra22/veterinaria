import java.time.LocalDateTime;

public class Tratamiento {
    private String descripcion; // Descripción del tratamiento
    private String diagnostico; // Diagnóstico de la mascota
    private LocalDateTime fechaHora; // Fecha y hora del tratamiento

    // Constructor
    public Tratamiento(String descripcion, String diagnostico, LocalDateTime fechaHora) {
        this.descripcion = descripcion;
        this.diagnostico = diagnostico;
        this.fechaHora = fechaHora;
    }

    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "descripcion='" + descripcion + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", fechaHora=" + fechaHora +
                '}';
    }
}
