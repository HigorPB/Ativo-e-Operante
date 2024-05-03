package br.unoeste.fipp.ativooperante2024.db.entities;

import jakarta.persistence.*;

@Entity
@Table(name="feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="fee_id")
    private Long id;
    @Column(name="fee_texto")
    private String text;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="den_id")
    private Denuncia denuncia;

    public Feedback() {
        this(0L, "", null);
    }

    public Feedback(Long id, String text, Denuncia denuncia) {
        this.id = id;
        this.text = text;
        this.denuncia = denuncia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }
}
