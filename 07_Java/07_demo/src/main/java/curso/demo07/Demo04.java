package curso.demo07;

public class Demo04 {
    
    // Constantes
    public static final int PUBLICATION_AUDIO = 0;
    public static final int PUBLICATION_VIDEO = 1;
    public static final int PUBLICATION_IMAGEN = 2;
    
    // Constantes mascara
    public static final int HAS_AUDIO = 1; //0b001;
    public static final int HAS_VIDEO = 2; //0b010;
    public static final int HAS_IMAGEN = 4; //0b100;
    
    public static void main(String[] args) {
        PublicationType type = PublicationType.AUDIO;
        
        System.out.println("Publication Type: " + type);
        if (type == PublicationType.AUDIO) {
            System.out.println(" - AUDIO - ");
        }

        switch(type) {
            case AUDIO:
                System.out.println("Es audio.");
                break;
            default:
                System.out.println("NO es audio.");
        }
        System.out.println();
        
        System.out.println("Valores de PublicationType:");
        for(PublicationType t : PublicationType.values()){
            System.out.println("\t" + t);
        }
        System.out.println();
        
        System.out.println("PublicationType.AUDIO: " + PublicationType.AUDIO);     
        System.out.println("PublicationType.valueOf(\"AUDIO\"): " + PublicationType.valueOf("AUDIO"));
        System.out.println();
        
        System.out.println("Extensión: " + type.getExtension());
    }
}

enum PublicationType {
    AUDIO {
        @Override
        public String getExtension() {
            return ".mp3";
        }
    },
    VIDEO,
    IMAGE;

    public String getExtension() {
        switch(this) { // el switch está preparado para coger valores de enum
            case AUDIO: return ".mp3";
            case VIDEO: return ".mp4";
            case IMAGE: return ".jpg";
            default: return null;    
        }
    }
}

enum PublicationType2 {
        // sus valores son como subclases, se puden poner constructores, etc
        // que el compilador crea autimatica mente
    AUDIO(".mp3"),
    VIDEO(".mp4"),
    IMAGE(".jpg");
    
    private String extension;

    private PublicationType2(String extension) {
        this.extension = extension;
    }

    public String getExtension(){
        return extension;
    }  
        
}

// equivale a 
class PublicationType_ {
    public static final PublicationType_Audio AUDIO = new PublicationType_Audio();
    public static final PublicationType_Video VIDEO = new PublicationType_Video();
    public static final PublicationType_Image IMAGEN = new PublicationType_Image();    
    
    public String getExtension() {
        if (this == AUDIO) {
            return ".mp3";
        } 
        else if (this == VIDEO) {
            return ".mp4";
        }
        else if (this == VIDEO) {
            return ".jpg";
        } 
        return null;
    }
    
}

class PublicationType_Audio extends PublicationType_ {

    @Override
    public String toString() {
        return "AUDIO";
    }
    
    @Override
    public String getExtension() {
            return ".mp3";
        }
    
}

class PublicationType_Video extends PublicationType_ {

    @Override
    public String toString() {
        return "VIDEO";
    }
    
}

class PublicationType_Image extends PublicationType_ {

    @Override
    public String toString() {
        return "IMAGE";
    }
    
}
