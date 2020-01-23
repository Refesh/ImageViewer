package imageAdjustment;

//ImageDisplay needs to know the dimension of the MainFrame to adjust the image, then i could pass the 
//MainFrame to the ImageDisplay to get that Dimension or do this solution with an interface because
//ImageDisplay shouldnt have access to the entire MainFrame only becasue it needs the Dimension of it.
public interface ObjectDimension {

    public Dimension getDimension();
}
