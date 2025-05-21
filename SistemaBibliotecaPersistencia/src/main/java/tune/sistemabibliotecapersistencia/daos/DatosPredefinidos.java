package tune.sistemabibliotecapersistencia.daos;

import tune.sistemabibliotecadominio.dtos.AlbumDTO;
import tune.sistemabibliotecadominio.dtos.ArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionDTO;
import tune.sistemabibliotecadominio.entidades.Artista;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatosPredefinidos {

    // Obtener lista de artistas solistas
    public static List<ArtistaDTO> obtenerArtistasSolistas() {
        List<ArtistaDTO> artistasSolistas = new ArrayList<>();

        // Aquí agregas los artistas solistas predefinidos
        artistasSolistas.add(new ArtistaDTO("Luis Miguel", "Solista", "Pop", "imagen_luis_miguel.jpg"));
        artistasSolistas.add(new ArtistaDTO("Shakira", "Solista", "Pop", "imagen_shakira.jpg"));

        return artistasSolistas;
    }

    // Obtener lista de bandas
    public static List<ArtistaDTO> obtenerBandas() {
        List<ArtistaDTO> bandas = new ArrayList<>();

        // Aquí agregas las bandas predefinidas
        bandas.add(new ArtistaDTO("Coldplay", "Banda", "Rock", "imagen_coldplay.jpg"));
        bandas.add(new ArtistaDTO("The Beatles", "Banda", "Rock", "imagen_beatles.jpg"));

        return bandas;
    }

    // Obtener álbumes de un artista específico
    public static List<AlbumDTO> obtenerAlbumesDeArtista(ArtistaDTO artistaDTO) {
        List<AlbumDTO> albumes = new ArrayList<>();

        if ("Luis Miguel".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO("Aries", LocalDate.of(1993, 10, 19), "Pop", "portada_aries.jpg", obtenerCancionesDeAlbum("Aries")));
            albumes.add(new AlbumDTO("Romance", LocalDate.of(1991, 6, 9), "Bolero", "portada_romance.jpg", obtenerCancionesDeAlbum("Romance")));
        }

        if ("Shakira".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO("Pies Descalzos", LocalDate.of(1995, 3, 6), "Pop", "portada_pies_descalzos.jpg", obtenerCancionesDeAlbum("Pies Descalzos")));
            albumes.add(new AlbumDTO("Laundry Service", LocalDate.of(2001, 11, 13), "Pop Rock", "portada_laundry_service.jpg", obtenerCancionesDeAlbum("Laundry Service")));
        }

        return albumes;
    }

    // Obtener álbumes de una banda específica
    public static List<AlbumDTO> obtenerAlbumesDeBanda(ArtistaDTO bandaDTO) {
        List<AlbumDTO> albumes = new ArrayList<>();

        if ("Coldplay".equals(bandaDTO.getNombre())) {
            albumes.add(new AlbumDTO("A Rush of Blood to the Head", LocalDate.of(2002, 8, 26), "Rock", "portada_rush_of_blood.jpg", obtenerCancionesDeAlbum("A Rush of Blood to the Head")));
            albumes.add(new AlbumDTO("X&Y", LocalDate.of(2005, 6, 6), "Rock", "portada_xy.jpg", obtenerCancionesDeAlbum("X&Y")));
        }

        if ("The Beatles".equals(bandaDTO.getNombre())) {
            albumes.add(new AlbumDTO("Abbey Road", LocalDate.of(1969, 9, 26), "Rock", "portada_abbey_road.jpg", obtenerCancionesDeAlbum("Abbey Road")));
            albumes.add(new AlbumDTO("Sgt. Pepper's Lonely Hearts Club Band", LocalDate.of(1967, 5, 26), "Rock", "portada_sgt_pepper.jpg", obtenerCancionesDeAlbum("Sgt. Pepper's Lonely Hearts Club Band")));
        }

        return albumes;
    }

    // Obtener canciones predefinidas para un álbum
    public static List<CancionDTO> obtenerCancionesDeAlbum(String albumNombre) {
        List<CancionDTO> canciones = new ArrayList<>();

        switch (albumNombre) {
            case "Aries":
                canciones.add(new CancionDTO("Hasta Mi Final", "3:42", "Pop"));
                canciones.add(new CancionDTO("Culpable o No", "4:10", "Pop"));
                canciones.add(new CancionDTO("La Incondicional", "4:00", "Pop"));
                break;
            case "Romance":
                canciones.add(new CancionDTO("No Sé Tú", "3:25", "Bolero"));
                canciones.add(new CancionDTO("Sabes Una Cosa", "4:15", "Bolero"));
                canciones.add(new CancionDTO("Solamente Tú", "3:50", "Bolero"));
                break;
            case "Pies Descalzos":
                canciones.add(new CancionDTO("Estoy Aquí", "3:33", "Pop"));
                canciones.add(new CancionDTO("Antología", "4:10", "Pop"));
                canciones.add(new CancionDTO("Pies Descalzos", "3:25", "Pop"));
                break;
            case "Laundry Service":
                canciones.add(new CancionDTO("Whenever, Wherever", "3:17", "Pop"));
                canciones.add(new CancionDTO("Underneath Your Clothes", "3:41", "Pop"));
                canciones.add(new CancionDTO("Objection (Tango)", "3:34", "Pop Rock"));
                break;
            case "A Rush of Blood to the Head":
                canciones.add(new CancionDTO("In My Place", "3:47", "Rock"));
                canciones.add(new CancionDTO("Clocks", "5:07", "Rock"));
                canciones.add(new CancionDTO("The Scientist", "5:09", "Rock"));
                break;
            case "X&Y":
                canciones.add(new CancionDTO("Fix You", "4:55", "Rock"));
                canciones.add(new CancionDTO("Speed of Sound", "4:18", "Rock"));
                canciones.add(new CancionDTO("Talk", "5:27", "Rock"));
                break;
            case "Abbey Road":
                canciones.add(new CancionDTO("Come Together", "4:20", "Rock"));
                canciones.add(new CancionDTO("Something", "3:03", "Rock"));
                canciones.add(new CancionDTO("Here Comes The Sun", "3:05", "Rock"));
                break;
            case "Sgt. Pepper's Lonely Hearts Club Band":
                canciones.add(new CancionDTO("Lucy in the Sky with Diamonds", "3:28", "Rock"));
                canciones.add(new CancionDTO("With a Little Help from My Friends", "2:44", "Rock"));
                canciones.add(new CancionDTO("A Day in the Life", "5:03", "Rock"));
                break;
            default:
                break;
        }

        return canciones;
    }
}
