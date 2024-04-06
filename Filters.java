
public class Filters{

// Convert a Bitmap Image to a grayscale version;
public static void grayScale(Bitmap bitmapSource, Bitmap bitmapResult)
        {
        Mat sourceMat = new Mat(); // This is the Matrix of the source Image
        Utils.bitmapToMat(bitmapSource,sourceMat);
        Mat resultMat = new Mat(); // This is the Matrix of the grayScale Image
        Imgproc.cvtColor(resultMat,sourceMat,Imgproc.COLOR_RGBA2GRAY);
        Utils.matToBitmap(resultMat,bitmapResult);
        }

// Convert a Bitmap Image to a sepia version;
 public static void applySepia(Bitmap sourceMat, Mat resultMat)
        {
        Mat sourceMat = new Mat();
        Utils.bitmapToMat(bitmapSource,sourceMat);
        Mat sepiaKernel = new Mat(3, 3, CvType.CV_32F);
        sepiaKernel.put(0, 0, 0.272f,0.534f , 0.131f);
        sepiaKernel.put(1, 0, 0.349f, 0.686f,  0.168f);
        sepiaKernel.put(2, 0, 0.393f, 0.769f, 0.189f);
        Core.transform(sourceMat, resultMat, sepiaKernel);
        Utils.matToBitmap(resultMat,bitmapResult);    
         }
        
// Edit the Hue-Saturation-Values of a source Mat and save it to a new Mat      
public static void changeHSV(Mat sourceMat, Mat resultMat,float HValue, float SValue, float VValue)
        {
        ArrayList<Mat> channelsHSV = new ArrayList<>();
        Imgproc.cvtColor(sourceMat, resultMat, Imgproc.COLOR_BGR2HSV);
        Core.split(resultMat,channelsHSV);
        Core.multiply(channelsHSV.get(0),new Scalar(HValue),channelsHSV.get(0));
        Core.multiply(channelsHSV.get(1),new Scalar(SValue),channelsHSV.get(1));
        Core.multiply(channelsHSV.get(2),new Scalar(VValue),channelsHSV.get(2));
        Core.merge(channelsHSV,resultMat);
        Imgproc.cvtColor(resultMat, resultMat, Imgproc.COLOR_HSV2BGR);
    }     
        
}
