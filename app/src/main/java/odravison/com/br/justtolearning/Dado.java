package odravison.com.br.justtolearning;

/**
 * Created by odravison on 14/10/16.
 */

public class Dado {


    private String name;

    private Integer id;


    public Dado() {
    }

    public Dado(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
