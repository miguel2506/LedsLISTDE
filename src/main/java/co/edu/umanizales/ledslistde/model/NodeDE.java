package co.edu.umanizales.ledslistde.model;

import lombok.Data;

@Data
public class NodeDE {

    private Led dataDE;

    private NodeDE nextDE;

    private NodeDE previous;

    public NodeDE(Led data) {
        this.dataDE = data;
    }

}
