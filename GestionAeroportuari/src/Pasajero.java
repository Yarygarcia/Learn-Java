public class Pasajero {
        private String name;
        private String idPasaporte;
        private String nacionalidad;

        public  Pasajero(String name, String idPasaporte, String nacionalidad){
            this.name = name;
            this.idPasaporte = idPasaporte;
            this.nacionalidad = nacionalidad;
        }
        public String getName(){
            return name;
        }
        public  String getIdPasaporte(){
            return idPasaporte;
        }
        public  String getNacionalidad(){
            return  nacionalidad;
        }

}
