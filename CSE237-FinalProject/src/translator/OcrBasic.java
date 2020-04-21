package translator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.ByteString;

import io.opencensus.metrics.export.Distribution.Bucket;

import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.api.Page;
import com.google.api.client.util.Lists;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;

// import net.sourceforge.tess4j.*; 
// import java.io.File;


public class OcrBasic {
	
	private String filename;
	private String result;
	
	public OcrBasic(String filename) {
		this.filename = filename;
	}
	
	
	public void request() throws FileNotFoundException, IOException {
		List<AnnotateImageRequest> requests = new ArrayList<>();
		
		
		System.setProperty("GOOGLE_API_KEY", "AIzaSyAw-dEwurJwyDGEh0xldnsOIAw_rUYkrSc");
		
		ByteString imgBytes = ByteString.readFrom(new FileInputStream(this.filename));
		Image img = Image.newBuilder().setContent(imgBytes).build();
		Feature feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build();
		AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
		requests.add(request);
		try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
		    BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
		    List<AnnotateImageResponse> responses = response.getResponsesList();

		    for (AnnotateImageResponse res : responses) {
		      if (res.hasError()) {
		        System.out.printf("Error: %s\n", res.getError().getMessage());
		        return;
		      }

		      // For full list of available annotations, see http://g.co/cloud/vision/docs
		      for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
		        System.out.printf("Text: %s\n", annotation.getDescription());
		        System.out.printf("Position : %s\n", annotation.getBoundingPoly());
		      }
		    }
		  }
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		OcrBasic ocr = new OcrBasic("example1.png");
		ocr.request();
	}

}
