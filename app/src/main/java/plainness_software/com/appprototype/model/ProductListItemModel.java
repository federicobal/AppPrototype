package plainness_software.com.appprototype.model;


import com.google.gson.annotations.SerializedName;

public class ProductListItemModel {
    @SerializedName("id")
    private int id;
    @SerializedName("overview")
    private String overview;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getOverview()
    {
        return overview;
    }
    public void setOverview(String overview)
    {
        this.overview = overview;
    }
    public ProductListItemModel(int id, String overview)
	{
        this.id = id;
        this.overview = overview;
	}
}
