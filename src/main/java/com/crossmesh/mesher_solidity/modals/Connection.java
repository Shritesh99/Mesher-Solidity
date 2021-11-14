package com.crossmesh.mesher_solidity.modals;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Connection {

    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("gasprice")
    @Expose
    private String gasprice;
    @SerializedName("gaslimit")
    @Expose
    private String gaslimit;
    @SerializedName("chainid")
    @Expose
    private Integer chainid;
    @SerializedName("structs")
    @Expose
    private String structs;
    @SerializedName("privatekey")
    @Expose
    private String privatekey;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getGasprice() {
        return gasprice;
    }

    public void setGasprice(String gasprice) {
        this.gasprice = gasprice;
    }

    public String getGaslimit() {
        return gaslimit;
    }

    public void setGaslimit(String gaslimit) {
        this.gaslimit = gaslimit;
    }

    public Integer getChainid() {
        return chainid;
    }

    public void setChainid(Integer chainid) {
        this.chainid = chainid;
    }

    public String getStructs() {
        return structs;
    }

    public void setStructs(String structs) {
        this.structs = structs;
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Connection.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("server");
        sb.append('=');
        sb.append(((this.server == null)?"<null>":this.server));
        sb.append(',');
        sb.append("gasprice");
        sb.append('=');
        sb.append(((this.gasprice == null)?"<null>":this.gasprice));
        sb.append(',');
        sb.append("gaslimit");
        sb.append('=');
        sb.append(((this.gaslimit == null)?"<null>":this.gaslimit));
        sb.append(',');
        sb.append("chainid");
        sb.append('=');
        sb.append(((this.chainid == null)?"<null>":this.chainid));
        sb.append(',');
        sb.append("structs");
        sb.append('=');
        sb.append(((this.structs == null)?"<null>":this.structs));
        sb.append(',');
        sb.append("privatekey");
        sb.append('=');
        sb.append(((this.privatekey == null)?"<null>":this.privatekey));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.server == null)? 0 :this.server.hashCode()));
        result = ((result* 31)+((this.privatekey == null)? 0 :this.privatekey.hashCode()));
        result = ((result* 31)+((this.gasprice == null)? 0 :this.gasprice.hashCode()));
        result = ((result* 31)+((this.gaslimit == null)? 0 :this.gaslimit.hashCode()));
        result = ((result* 31)+((this.chainid == null)? 0 :this.chainid.hashCode()));
        result = ((result* 31)+((this.structs == null)? 0 :this.structs.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Connection) == false) {
            return false;
        }
        Connection rhs = ((Connection) other);
        return (((((((this.server == rhs.server)||((this.server!= null)&&this.server.equals(rhs.server)))&&((this.privatekey == rhs.privatekey)||((this.privatekey!= null)&&this.privatekey.equals(rhs.privatekey))))&&((this.gasprice == rhs.gasprice)||((this.gasprice!= null)&&this.gasprice.equals(rhs.gasprice))))&&((this.gaslimit == rhs.gaslimit)||((this.gaslimit!= null)&&this.gaslimit.equals(rhs.gaslimit))))&&((this.chainid == rhs.chainid)||((this.chainid!= null)&&this.chainid.equals(rhs.chainid))))&&((this.structs == rhs.structs)||((this.structs!= null)&&this.structs.equals(rhs.structs))));
    }

}