package tune.sistemabibliotecapersistencia.daos;

import tune.sistemabibliotecadominio.dtos.AlbumDTO;
import tune.sistemabibliotecadominio.dtos.ArtistaDTO;
import tune.sistemabibliotecadominio.dtos.CancionDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tune.sistemabibliotecadominio.dtos.IntegranteDTO;

public class DatosPredefinidos {

    public static List<ArtistaDTO> obtenerArtistasSolistas() {
        List<ArtistaDTO> artistasSolistas = new ArrayList<>();

        artistasSolistas.add(new ArtistaDTO("Shakira", "Solista", "Pop", "imagen_solista1.jpg"));
        artistasSolistas.add(new ArtistaDTO("James Arthur", "Solista", "Pop", "imagen_solista2.jpg"));
        artistasSolistas.add(new ArtistaDTO("Christian Nodal", "Solista", "Nortena", "imagen_solista3.jpg"));
        artistasSolistas.add(new ArtistaDTO("Yuridia", "Solista", "Pop", "imagen_solista4.jpg"));
        artistasSolistas.add(new ArtistaDTO("Gloria Trevi", "Solista", "Pop Latino", "imagen_solista5.jpg"));
        artistasSolistas.add(new ArtistaDTO("Belinda", "Solista", "Pop", "imagen_solista6.jpg"));
        artistasSolistas.add(new ArtistaDTO("Humbe", "Solista", "Pop Latino", "imagen_solista7.jpg"));
        artistasSolistas.add(new ArtistaDTO("Ariana Grande", "Solista", "Pop", "imagen_solista8.jpg"));
        artistasSolistas.add(new ArtistaDTO("Lit Killah", "Solista", "Trap", "imagen_solista9.jpg"));
        artistasSolistas.add(new ArtistaDTO("Paulo Londra", "Solista", "Trap", "imagen_solista10.jpg"));
        artistasSolistas.add(new ArtistaDTO("Maria Becerra", "Solista", "Pop", "imagen_solista11.jpg"));
        artistasSolistas.add(new ArtistaDTO("Trueno", "Solista", "Trap", "imagen_solista12.jpg"));
        artistasSolistas.add(new ArtistaDTO("Nicki Nicole", "Solista", "Hip Hop", "imagen_solista13.jpg"));
        artistasSolistas.add(new ArtistaDTO("Khea", "Solista", "Trap", "imagen_solista14.jpg"));
        artistasSolistas.add(new ArtistaDTO("Milo J", "Solista", "Rap", "imagen_solista15.jpg"));
        
        artistasSolistas.add(new ArtistaDTO("Vicente Fernandez", "Solista", "Regional", "imagen_solista1.jpg"));
        artistasSolistas.add(new ArtistaDTO("Jose Jose", "Solista", "Bolero", "imagen_solista2.jpg"));
        artistasSolistas.add(new ArtistaDTO("Lucero", "Solista", "Pop", "imagen_solista3.jpg"));
        artistasSolistas.add(new ArtistaDTO("Sabrina Carpenter", "Pop", "Pop", "imagen_solista4.jpg"));
        artistasSolistas.add(new ArtistaDTO("Fufu", "Solista", "Rap", "imagen_solista5.jpg"));
        artistasSolistas.add(new ArtistaDTO("Beret", "Solista", "Rap", "imagen_solista6.jpg"));
        artistasSolistas.add(new ArtistaDTO("Adrian L Santo", "Solista", "Regional", "imagen_solista7.jpg"));
        artistasSolistas.add(new ArtistaDTO("Ivan Cornejo", "Solista", "Regional", "imagen_solista8.jpg"));
        artistasSolistas.add(new ArtistaDTO("Mitski", "Solista", "Indie", "imagen_solista9.jpg"));
        artistasSolistas.add(new ArtistaDTO("Lana del Rey", "Solista", "Indie", "imagen_solista10.jpg"));
        artistasSolistas.add(new ArtistaDTO("Alex Ponce", "Solista", "Pop", "imagen_solista11.jpg"));
        artistasSolistas.add(new ArtistaDTO("Junior H", "Solista", "Hip Hop", "imagen_solista12.jpg"));
        artistasSolistas.add(new ArtistaDTO("Arcangel", "Solista", "Reggaeton", "imagen_solista13.jpg"));
        artistasSolistas.add(new ArtistaDTO("Bizarrap", "Solista", "Trap", "imagen_solista14.jpg"));
        artistasSolistas.add(new ArtistaDTO("Babi", "Solista", "Trap", "imagen_solista15.jpg"));

        return artistasSolistas;
    }

    public static List<ArtistaDTO> obtenerBandas() {
        List<ArtistaDTO> bandas = new ArrayList<>();
        
        List<IntegranteDTO> integrantesLatinMafia = new ArrayList<>();
        integrantesLatinMafia.add(new IntegranteDTO("Juan Pérez", "Vocalista", LocalDate.of(2010, 1, 10), "Activo"));
        integrantesLatinMafia.add(new IntegranteDTO("Carlos López", "Guitarrista", LocalDate.of(2010, 1, 10), "Activo"));
        integrantesLatinMafia.add(new IntegranteDTO("Miguel Sánchez", "Bajista", LocalDate.of(2010, 1, 10), "Activo"));
        bandas.add(new ArtistaDTO("Latin Mafia", "Banda", "Pop", "imagen_banda1.jpg", integrantesLatinMafia));
        
        List<IntegranteDTO> integrantesZoe = new ArrayList<>();       
        integrantesZoe.add(new IntegranteDTO("Sergio Vega", "Bajista", LocalDate.of(1997, 1, 1), "Activo"));
        integrantesZoe.add(new IntegranteDTO("Cruz Martínez", "Guitarrista", LocalDate.of(1997, 1, 1), "Activo"));
        integrantesZoe.add(new IntegranteDTO("Ángel Mosqueda", "Batería", LocalDate.of(1997, 1, 1), "Activo"));
        integrantesZoe.add(new IntegranteDTO("León Larregui", "Vocalista", LocalDate.of(1997, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Zoe", "Banda", "Pop", "imagen_banda2.jpg", integrantesZoe));
        
        List<IntegranteDTO> integrantes3AM = new ArrayList<>();
        integrantes3AM.add(new IntegranteDTO("Emmanuel Loza", "Vocalista", LocalDate.of(2000, 1, 1), "Activo"));
        integrantes3AM.add(new IntegranteDTO("Luis Miguel Martínez", "Guitarrista", LocalDate.of(2000, 1, 1), "Activo"));
        integrantes3AM.add(new IntegranteDTO("Alfredo Herrera", "Batería", LocalDate.of(2000, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("3AM", "Banda", "Urbano", "imagen_banda3.jpg", integrantes3AM));
        
        List<IntegranteDTO> integrantesFuerzaRegida = new ArrayList<>();
        integrantesFuerzaRegida.add(new IntegranteDTO("Javier Fernández", "Vocalista", LocalDate.of(2010, 1, 1), "Activo"));
        integrantesFuerzaRegida.add(new IntegranteDTO("Eduardo López", "Acordeonista", LocalDate.of(2010, 1, 1), "Activo"));
        integrantesFuerzaRegida.add(new IntegranteDTO("Mario García", "Bajista", LocalDate.of(2010, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Fuerza Regida", "Banda", "Regional", "imagen_banda4.jpg", integrantesFuerzaRegida));
        
        List<IntegranteDTO> integrantesReik = new ArrayList<>();
        integrantesReik.add(new IntegranteDTO("Jesús Navarro", "Vocalista", LocalDate.of(2003, 1, 1), "Activo"));
        integrantesReik.add(new IntegranteDTO("Julio Ramírez", "Guitarrista", LocalDate.of(2003, 1, 1), "Activo"));
        integrantesReik.add(new IntegranteDTO("Gilberto Marín", "Tecladista", LocalDate.of(2003, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Reik", "Banda", "Pop Latino", "imagen_banda5.jpg", integrantesReik));
        
        List<IntegranteDTO> integrantesMorat = new ArrayList<>();
        integrantesMorat.add(new IntegranteDTO("Juan Pablo Isaza", "Vocalista/Guitarra", LocalDate.of(2015, 1, 1), "Activo"));
        integrantesMorat.add(new IntegranteDTO("Simón Vargas", "Bajo", LocalDate.of(2015, 1, 1), "Activo"));
        integrantesMorat.add(new IntegranteDTO("Martín Vargas", "Batería", LocalDate.of(2015, 1, 1), "Activo"));
        integrantesMorat.add(new IntegranteDTO("Alejandro Posada", "Guitarra", LocalDate.of(2015, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Morat", "Banda", "Pop", "imagen_banda6.jpg", integrantesMorat));
        
        List<IntegranteDTO> integrantesBlackpink = new ArrayList<>();
        integrantesBlackpink.add(new IntegranteDTO("Jisoo", "Vocalista", LocalDate.of(2016, 8, 8), "Activo"));
        integrantesBlackpink.add(new IntegranteDTO("Jennie", "Rapper/Vocalista", LocalDate.of(2016, 8, 8), "Activo"));
        integrantesBlackpink.add(new IntegranteDTO("Rosé", "Vocalista", LocalDate.of(2016, 8, 8), "Activo"));
        integrantesBlackpink.add(new IntegranteDTO("Lisa", "Bailarina/Rapper", LocalDate.of(2016, 8, 8), "Activo"));
        bandas.add(new ArtistaDTO("Blackpink", "Banda", "K-Pop", "imagen_banda7.jpg", integrantesBlackpink));
        
        List<IntegranteDTO> integrantesKevinKaarl = new ArrayList<>();
        integrantesKevinKaarl.add(new IntegranteDTO("Kevin Kaarl", "Vocalista/Guitarra", LocalDate.of(2018, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Kevin Kaarl", "Banda", "Indie", "imagen_banda8.jpg", integrantesKevinKaarl));
        
        List<IntegranteDTO> integrantesManeskin = new ArrayList<>();
        integrantesManeskin.add(new IntegranteDTO("Damiano David", "Vocalista", LocalDate.of(2016, 1, 1), "Activo"));
        integrantesManeskin.add(new IntegranteDTO("Victoria De Angelis", "Bajista", LocalDate.of(2016, 1, 1), "Activo"));
        integrantesManeskin.add(new IntegranteDTO("Thomas Raggi", "Guitarrista", LocalDate.of(2016, 1, 1), "Activo"));
        integrantesManeskin.add(new IntegranteDTO("Ethan Torchio", "Batería", LocalDate.of(2016, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Maneskin", "Banda", "Pop", "imagen_banda9.jpg", integrantesManeskin));
        
        List<IntegranteDTO> integrantesTOP = new ArrayList<>();
        integrantesTOP.add(new IntegranteDTO("Tyler Joseph", "Vocalista/Teclado", LocalDate.of(2009, 1, 1), "Activo"));
        integrantesTOP.add(new IntegranteDTO("Josh Dun", "Batería", LocalDate.of(2011, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Twenty One Pilots", "Banda", "Hip Hop", "imagen_banda10.jpg", integrantesTOP));
        
        List<IntegranteDTO> integrantesArcticMonkeys = new ArrayList<>();
        integrantesArcticMonkeys.add(new IntegranteDTO("Alex Turner", "Vocalista/Guitarrista", LocalDate.of(2002, 1, 1), "Activo"));
        integrantesArcticMonkeys.add(new IntegranteDTO("Jamie Cook", "Guitarrista", LocalDate.of(2002, 1, 1), "Activo"));
        integrantesArcticMonkeys.add(new IntegranteDTO("Nick O'Malley", "Bajista", LocalDate.of(2006, 1, 1), "Activo"));
        integrantesArcticMonkeys.add(new IntegranteDTO("Matt Helders", "Batería", LocalDate.of(2002, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Arctic Monkeys", "Banda", "Indie", "imagen_banda11.jpg", integrantesArcticMonkeys));
        
        List<IntegranteDTO> integrantesKiss = new ArrayList<>();
        integrantesKiss.add(new IntegranteDTO("Paul Stanley", "Vocalista/Guitarrista", LocalDate.of(1973, 1, 1), "Activo"));
        integrantesKiss.add(new IntegranteDTO("Gene Simmons", "Bajista/Vocalista", LocalDate.of(1973, 1, 1), "Activo"));
        integrantesKiss.add(new IntegranteDTO("Eric Singer", "Batería", LocalDate.of(1991, 1, 1), "Activo"));
        integrantesKiss.add(new IntegranteDTO("Tommy Thayer", "Guitarrista", LocalDate.of(2002, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("KISS", "Banda", "Rock", "imagen_banda12.jpg", integrantesKiss));
        
        List<IntegranteDTO> integrantesKeane = new ArrayList<>();
        integrantesKeane.add(new IntegranteDTO("Tom Chaplin", "Vocalista", LocalDate.of(1995, 1, 1), "Activo"));
        integrantesKeane.add(new IntegranteDTO("Tim Rice-Oxley", "Tecladista", LocalDate.of(1995, 1, 1), "Activo"));
        integrantesKeane.add(new IntegranteDTO("Richard Hughes", "Batería", LocalDate.of(1995, 1, 1), "Activo"));
        integrantesKeane.add(new IntegranteDTO("Jesse Quin", "Bajista", LocalDate.of(2007, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Keane", "Banda", "Rock", "imagen_banda13.jpg", integrantesKeane));
        
        List<IntegranteDTO> integrantesQueen = new ArrayList<>();
        integrantesQueen.add(new IntegranteDTO("Freddie Mercury", "Vocalista", LocalDate.of(1970, 1, 1), "Fallecido"));
        integrantesQueen.add(new IntegranteDTO("Brian May", "Guitarrista", LocalDate.of(1970, 1, 1), "Activo"));
        integrantesQueen.add(new IntegranteDTO("Roger Taylor", "Batería", LocalDate.of(1970, 1, 1), "Activo"));
        integrantesQueen.add(new IntegranteDTO("John Deacon", "Bajista", LocalDate.of(1970, 1, 1), "Retirado"));
        bandas.add(new ArtistaDTO("Queen", "Banda", "Rock", "imagen_banda14.jpg", integrantesQueen));
        
        List<IntegranteDTO> integrantesSinBandera = new ArrayList<>();
        integrantesSinBandera.add(new IntegranteDTO("Leonel García", "Vocalista", LocalDate.of(2000, 1, 1), "Activo"));
        integrantesSinBandera.add(new IntegranteDTO("Noel Schajris", "Vocalista", LocalDate.of(2000, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Sin bandera", "Banda", "Bolero", "imagen_banda15.jpg", integrantesSinBandera));
        
        List<IntegranteDTO> integrantesBTR = new ArrayList<>();
        integrantesBTR.add(new IntegranteDTO("Kendall Schmidt", "Vocalista", LocalDate.of(2009, 1, 1), "Inactivo"));
        integrantesBTR.add(new IntegranteDTO("James Maslow", "Vocalista", LocalDate.of(2009, 1, 1), "Inactivo"));
        integrantesBTR.add(new IntegranteDTO("Carlos Pena Jr.", "Vocalista", LocalDate.of(2009, 1, 1), "Inactivo"));
        integrantesBTR.add(new IntegranteDTO("Logan Henderson", "Vocalista", LocalDate.of(2009, 1, 1), "Inactivo"));
        bandas.add(new ArtistaDTO("Big Time Rush", "Banda", "Pop", "imagen_banda1.jpg", integrantesBTR));
        
        List<IntegranteDTO> integrantesOD = new ArrayList<>();
        integrantesOD.add(new IntegranteDTO("Harry Styles", "Vocalista", LocalDate.of(2010, 1, 1), "Inactivo"));
        integrantesOD.add(new IntegranteDTO("Liam Payne", "Vocalista", LocalDate.of(2010, 1, 1), "Inactivo"));
        integrantesOD.add(new IntegranteDTO("Louis Tomlinson", "Vocalista", LocalDate.of(2010, 1, 1), "Inactivo"));
        integrantesOD.add(new IntegranteDTO("Niall Horan", "Vocalista", LocalDate.of(2010, 1, 1), "Inactivo"));
        integrantesOD.add(new IntegranteDTO("Zayn Malik", "Vocalista", LocalDate.of(2010, 1, 1), "Inactivo"));
        bandas.add(new ArtistaDTO("One Direction", "Banda", "Pop", "imagen_banda2.jpg", integrantesOD));
        
        List<IntegranteDTO> integrantesCD9 = new ArrayList<>();
        integrantesCD9.add(new IntegranteDTO("Yankel Stevan", "Vocalista", LocalDate.of(2010, 1, 1), "Activo"));
        integrantesCD9.add(new IntegranteDTO("Alan Navarro", "Vocalista", LocalDate.of(2010, 1, 1), "Activo"));
        integrantesCD9.add(new IntegranteDTO("Jos Canela", "Vocalista", LocalDate.of(2010, 1, 1), "Activo"));
        integrantesCD9.add(new IntegranteDTO("Christopher Vélez", "Vocalista", LocalDate.of(2010, 1, 1), "Activo"));
        integrantesCD9.add(new IntegranteDTO("Dylan Ruiz", "Vocalista", LocalDate.of(2010, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("CD9", "Banda", "Pop", "imagen_banda3.jpg", integrantesCD9));
        
        List<IntegranteDTO> integrantesPlanB = new ArrayList<>();
        integrantesPlanB.add(new IntegranteDTO("Chencho Corleone", "Vocalista", LocalDate.of(2002, 1, 1), "Activo"));
        integrantesPlanB.add(new IntegranteDTO("Maldy", "Vocalista", LocalDate.of(2002, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Plan B", "Banda", "Reggaeton", "imagen_banda4.jpg", integrantesPlanB));
        
        List<IntegranteDTO> integrantesEnjambre = new ArrayList<>();
        integrantesEnjambre.add(new IntegranteDTO("Ricardo López", "Vocalista/Guitarrista", LocalDate.of(2000, 1, 1), "Activo"));
        integrantesEnjambre.add(new IntegranteDTO("Abie Toiber", "Batería", LocalDate.of(2000, 1, 1), "Activo"));
        integrantesEnjambre.add(new IntegranteDTO("Juan Pablo Rodríguez", "Teclados", LocalDate.of(2000, 1, 1), "Activo"));
        integrantesEnjambre.add(new IntegranteDTO("Manuel Vázquez", "Bajo", LocalDate.of(2000, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Enjambre", "Banda", "Rock", "imagen_banda5.jpg", integrantesEnjambre));
        
        List<IntegranteDTO> integrantesBandaMS = new ArrayList<>();
        integrantesBandaMS.add(new IntegranteDTO("Alfredo Olivas", "Vocalista", LocalDate.of(2003, 1, 1), "Activo"));
        integrantesBandaMS.add(new IntegranteDTO("Erick García", "Bajista", LocalDate.of(2003, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Banda MS", "Banda", "Regional", "imagen_banda6.jpg", integrantesBandaMS));
        
        List<IntegranteDTO> integrantesMYA = new ArrayList<>();
        integrantesMYA.add(new IntegranteDTO("Maxi Espíndola", "Vocalista", LocalDate.of(2016, 1, 1), "Activo"));
        integrantesMYA.add(new IntegranteDTO("Agustín Bernasconi", "Vocalista", LocalDate.of(2016, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("MYA", "Banda", "Urbano", "imagen_banda7.jpg", integrantesMYA));
        
        List<IntegranteDTO> integrantesDeftones = new ArrayList<>();
        integrantesDeftones.add(new IntegranteDTO("Chino Moreno", "Vocalista", LocalDate.of(1988, 1, 1), "Activo"));
        integrantesDeftones.add(new IntegranteDTO("Stephen Carpenter", "Guitarrista", LocalDate.of(1988, 1, 1), "Activo"));
        integrantesDeftones.add(new IntegranteDTO("Abe Cunningham", "Batería", LocalDate.of(1988, 1, 1), "Activo"));
        integrantesDeftones.add(new IntegranteDTO("Sergio Vega", "Bajista", LocalDate.of(2009, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Deftones", "Banda", "Rock", "imagen_banda8.jpg", integrantesDeftones));
        
        List<IntegranteDTO> integrantesTN = new ArrayList<>();
        integrantesTN.add(new IntegranteDTO("Jesse Rutherford", "Vocalista", LocalDate.of(2011, 1, 1), "Activo"));
        integrantesTN.add(new IntegranteDTO("Jeremy Freedman", "Guitarrista", LocalDate.of(2011, 1, 1), "Activo"));
        integrantesTN.add(new IntegranteDTO("Zach Abels", "Guitarrista", LocalDate.of(2011, 1, 1), "Activo"));
        integrantesTN.add(new IntegranteDTO("Mikey Margott", "Bajista", LocalDate.of(2011, 1, 1), "Activo"));
        integrantesTN.add(new IntegranteDTO("Brandon Fried", "Batería", LocalDate.of(2011, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("The neighbourhood", "Banda", "Pop", "imagen_banda9.jpg", integrantesTN));
        
        List<IntegranteDTO> integrantesGrupoFrontera = new ArrayList<>();
        bandas.add(new ArtistaDTO("Grupo Frontera", "Banda", "Regional", "imagen_banda10.jpg", integrantesGrupoFrontera));
        
        List<IntegranteDTO> integrantesGrupoFirme = new ArrayList<>();
        integrantesGrupoFirme.add(new IntegranteDTO("Eduin Caz", "Vocalista", LocalDate.of(2014, 1, 1), "Activo"));
        integrantesGrupoFirme.add(new IntegranteDTO("Jorge Romero", "Batería", LocalDate.of(2014, 1, 1), "Activo"));
        integrantesGrupoFirme.add(new IntegranteDTO("Gerardo Vargas", "Bajista", LocalDate.of(2014, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Grupo Firme", "Banda", "Regional", "imagen_banda11.jpg", integrantesGrupoFirme));
        
        List<IntegranteDTO> integrantesTheWalters = new ArrayList<>();
        integrantesTheWalters.add(new IntegranteDTO("Luke Olson", "Vocalista/Guitarrista", LocalDate.of(2014, 1, 1), "Activo"));
        integrantesTheWalters.add(new IntegranteDTO("Cole Preston", "Batería", LocalDate.of(2014, 1, 1), "Activo"));
        integrantesTheWalters.add(new IntegranteDTO("Walter Kosner", "Bajista", LocalDate.of(2014, 1, 1), "Activo"));
        integrantesTheWalters.add(new IntegranteDTO("Danny Wells", "Guitarrista", LocalDate.of(2014, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("The Walters", "Banda", "Alternativo", "imagen_banda12.jpg", integrantesTheWalters));
        
        List<IntegranteDTO> integrantesElCuarteto = new ArrayList<>();
        integrantesElCuarteto.add(new IntegranteDTO("Roberto Musso", "Vocalista/Guitarra", LocalDate.of(1984, 1, 1), "Activo"));
        integrantesElCuarteto.add(new IntegranteDTO("Santiago Tavella", "Bajo", LocalDate.of(1984, 1, 1), "Activo"));
        integrantesElCuarteto.add(new IntegranteDTO("Alvaro Pintos", "Teclados", LocalDate.of(1984, 1, 1), "Activo"));
        integrantesElCuarteto.add(new IntegranteDTO("Gustavo Antuña", "Batería", LocalDate.of(1984, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("El cuarteto de nos", "Banda", "Rock", "imagen_banda13.jpg", integrantesElCuarteto));
        
        List<IntegranteDTO> integrantesGR = new ArrayList<>();
        integrantesGR.add(new IntegranteDTO("Axl Rose", "Vocalista", LocalDate.of(1985, 1, 1), "Activo"));
        integrantesGR.add(new IntegranteDTO("Slash", "Guitarrista", LocalDate.of(1985, 1, 1), "Activo"));
        integrantesGR.add(new IntegranteDTO("Duff McKagan", "Bajista", LocalDate.of(1985, 1, 1), "Activo"));
        integrantesGR.add(new IntegranteDTO("Steven Adler", "Batería", LocalDate.of(1985, 1, 1), "Retirado"));
        bandas.add(new ArtistaDTO("Guns & Roses", "Banda", "Rock", "imagen_banda14.jpg", integrantesGR));
        
        List<IntegranteDTO> integrantesRBD = new ArrayList<>();
        integrantesRBD.add(new IntegranteDTO("Anahí", "Vocalista", LocalDate.of(2004, 1, 1), "Inactivo"));
        integrantesRBD.add(new IntegranteDTO("Dulce María", "Vocalista", LocalDate.of(2004, 1, 1), "Inactivo"));
        integrantesRBD.add(new IntegranteDTO("Maite Perroni", "Vocalista", LocalDate.of(2004, 1, 1), "Inactivo"));
        integrantesRBD.add(new IntegranteDTO("Alfonso Herrera", "Vocalista", LocalDate.of(2004, 1, 1), "Inactivo"));
        integrantesRBD.add(new IntegranteDTO("Christian Chávez", "Vocalista", LocalDate.of(2004, 1, 1), "Inactivo"));
        integrantesRBD.add(new IntegranteDTO("Christopher von Uckermann", "Vocalista", LocalDate.of(2004, 1, 1), "Inactivo"));
        bandas.add(new ArtistaDTO("RBD", "Banda", "Indie", "imagen_banda15.jpg", integrantesRBD));

        return bandas;
    }

    public static List<AlbumDTO> obtenerAlbumesDeArtista(ArtistaDTO artistaDTO) {
        List<AlbumDTO> albumes = new ArrayList<>();

        if ("Shakira".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Pies Descalzos",
                LocalDate.of(1995, 3, 6),
                "Pop",
                "portada_pies_descalzos.jpg",
                obtenerCancionesDeAlbum("Pies Descalzos")
            ));
            albumes.add(new AlbumDTO(
                "Laundry Service",
                LocalDate.of(2001, 11, 13),
                "Pop Rock",
                "portada_laundry_service.jpg",
                obtenerCancionesDeAlbum("Laundry Service")
            ));
        }

        if ("James Arthur".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "James Arthur",
                LocalDate.of(2013, 11, 1),
                "Pop",
                "portada_james_arthur.jpg",
                obtenerCancionesDeAlbum("James Arthur")
            ));
            albumes.add(new AlbumDTO(
                "You",
                LocalDate.of(2019, 10, 18),
                "Pop",
                "portada_you.jpg",
                obtenerCancionesDeAlbum("You")
            ));
        }

        if ("Christian Nodal".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Me Dejé Llevar",
                LocalDate.of(2017, 5, 12),
                "Norteña",
                "portada_me_deje_llevar.jpg",
                obtenerCancionesDeAlbum("Me Dejé Llevar")
            ));
            albumes.add(new AlbumDTO(
                "Ahora",
                LocalDate.of(2019, 5, 10),
                "Regional",
                "portada_ahora.jpg",
                obtenerCancionesDeAlbum("Ahora")
            ));
        }

        if ("Yuridia".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Habla El Corazón",
                LocalDate.of(2006, 11, 21),
                "Pop",
                "portada_habla_el_corazon.jpg",
                obtenerCancionesDeAlbum("Habla El Corazón")
            ));
            albumes.add(new AlbumDTO(
                "Nada Es Color De Rosa",
                LocalDate.of(2009, 10, 27),
                "Pop",
                "portada_nada_es_color_de_rosa.jpg",
                obtenerCancionesDeAlbum("Nada Es Color De Rosa")
            ));
        }

        if ("Gloria Trevi".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Me siento viva",
                LocalDate.of(2004, 3, 23),
                "Pop Latino",
                "portada_me_siento_viva.jpg",
                obtenerCancionesDeAlbum("Me siento viva")
            ));
            albumes.add(new AlbumDTO(
                "De Película",
                LocalDate.of(2013, 9, 3),
                "Pop Latino",
                "portada_de_pelicula.jpg",
                obtenerCancionesDeAlbum("De Película")
            ));
        }
        
        if ("Belinda".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Belinda",
                LocalDate.of(2003, 8, 5),
                "Pop",
                "portada_belinda.jpg",
                obtenerCancionesDeAlbum("Belinda")
            ));
            albumes.add(new AlbumDTO(
                "Utopía",
                LocalDate.of(2006, 10, 3),
                "Pop",
                "portada_utopia.jpg",
                obtenerCancionesDeAlbum("Utopía")
            ));
        }

        if ("Humbe".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Primera Estrella",
                LocalDate.of(2021, 5, 20),
                "Pop Latino",
                "portada_primera_estrella.jpg",
                obtenerCancionesDeAlbum("Primera Estrella")
            ));
        }

        if ("Ariana Grande".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Yours Truly",
                LocalDate.of(2013, 8, 30),
                "Pop",
                "portada_yours_truly.jpg",
                obtenerCancionesDeAlbum("Yours Truly")
            ));
            albumes.add(new AlbumDTO(
                "Sweetener",
                LocalDate.of(2018, 8, 17),
                "Pop",
                "portada_sweetener.jpg",
                obtenerCancionesDeAlbum("Sweetener")
            ));
        }

        if ("Lit Killah".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "MAWZ",
                LocalDate.of(2020, 4, 23),
                "Trap",
                "portada_mawz.jpg",
                obtenerCancionesDeAlbum("MAWZ")
            ));
        }

        if ("Paulo Londra".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Homerun",
                LocalDate.of(2019, 5, 23),
                "Trap",
                "portada_homerun.jpg",
                obtenerCancionesDeAlbum("Homerun")
            ));
        }

        if ("Maria Becerra".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Animal",
                LocalDate.of(2021, 8, 26),
                "Pop",
                "portada_animal.jpg",
                obtenerCancionesDeAlbum("Animal")
            ));
        }

        if ("Trueno".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Atrevido",
                LocalDate.of(2020, 7, 23),
                "Trap",
                "portada_atrevido.jpg",
                obtenerCancionesDeAlbum("Atrevido")
            ));
        }

        if ("Nicki Nicole".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Recuerdos",
                LocalDate.of(2019, 11, 8),
                "Hip Hop",
                "portada_recuerdos.jpg",
                obtenerCancionesDeAlbum("Recuerdos")
            ));
        }

        if ("Khea".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Trapicheo",
                LocalDate.of(2019, 7, 12),
                "Trap",
                "portada_trapicheo.jpg",
                obtenerCancionesDeAlbum("Trapicheo")
            ));
        }

        if ("Milo J".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Julio",
                LocalDate.of(2021, 1, 15),
                "Rap",
                "portada_julio.jpg",
                obtenerCancionesDeAlbum("Julio")
            ));
        }
        
        if ("Vicente Fernandez".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Para Siempre",
                LocalDate.of(2007, 11, 6),
                "Regional",
                "portada_para_siempre.jpg",
                obtenerCancionesDeAlbum("Para Siempre")
            ));
            albumes.add(new AlbumDTO(
                "Recuerdos, Vol. II",
                LocalDate.of(1984, 1, 1),
                "Regional",
                "portada_recuerdos_vol2.jpg",
                obtenerCancionesDeAlbum("Recuerdos, Vol. II")
            ));
        }

        if ("Jose Jose".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Secretos",
                LocalDate.of(1983, 9, 20),
                "Bolero",
                "portada_secretos.jpg",
                obtenerCancionesDeAlbum("Secretos")
            ));
            albumes.add(new AlbumDTO(
                "Volcán",
                LocalDate.of(1978, 1, 1),
                "Bolero",
                "portada_volcan.jpg",
                obtenerCancionesDeAlbum("Volcán")
            ));
        }

        if ("Lucero".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Un Nuevo Amor",
                LocalDate.of(1996, 1, 1),
                "Pop",
                "portada_un_nuevo_amor.jpg",
                obtenerCancionesDeAlbum("Un Nuevo Amor")
            ));
            albumes.add(new AlbumDTO(
                "Quiéreme Tal Como Soy",
                LocalDate.of(2006, 1, 1),
                "Pop",
                "portada_quiereme_tal_como_soy.jpg",
                obtenerCancionesDeAlbum("Quiéreme Tal Como Soy")
            ));
        }

        if ("Sabrina Carpenter".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Singular: Act I",
                LocalDate.of(2018, 11, 9),
                "Pop",
                "portada_singular_act1.jpg",
                obtenerCancionesDeAlbum("Singular: Act I")
            ));
            albumes.add(new AlbumDTO(
                "Singular: Act II",
                LocalDate.of(2019, 7, 19),
                "Pop",
                "portada_singular_act2.jpg",
                obtenerCancionesDeAlbum("Singular: Act II")
            ));
        }

        if ("Fufu".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Simetría",
                LocalDate.of(2021, 2, 15),
                "Rap",
                "portada_simetria.jpg",
                obtenerCancionesDeAlbum("Simetría")
            ));
        }

        if ("Beret".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Prisma",
                LocalDate.of(2019, 2, 22),
                "Rap",
                "portada_prisma.jpg",
                obtenerCancionesDeAlbum("Prisma")
            ));
        }

        if ("Adrian L Santo".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Que Me Lleve El Diablo",
                LocalDate.of(2019, 6, 21),
                "Regional",
                "portada_que_me_lleve_el_diablo.jpg",
                obtenerCancionesDeAlbum("Que Me Lleve El Diablo")
            ));
        }

        if ("Ivan Cornejo".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Alma Vacía",
                LocalDate.of(2020, 11, 6),
                "Regional",
                "portada_alma_vacia.jpg",
                obtenerCancionesDeAlbum("Alma Vacía")
            ));
        }

        if ("Mitski".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Be the Cowboy",
                LocalDate.of(2018, 8, 17),
                "Indie",
                "portada_be_the_cowboy.jpg",
                obtenerCancionesDeAlbum("Be the Cowboy")
            ));
        }

        if ("Lana del Rey".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Norman Fucking Rockwell!",
                LocalDate.of(2019, 8, 30),
                "Indie",
                "portada_norman_fucking_rockwell.jpg",
                obtenerCancionesDeAlbum("Norman Fucking Rockwell!")
            ));
        }

        if ("Alex Ponce".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Soul Urbano",
                LocalDate.of(2021, 3, 5),
                "Pop",
                "portada_soul_urbano.jpg",
                obtenerCancionesDeAlbum("Soul Urbano")
            ));
        }

        if ("Junior H".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Atrapado en un sueño",
                LocalDate.of(2020, 10, 16),
                "Hip Hop",
                "portada_atrapado_en_un_sueno.jpg",
                obtenerCancionesDeAlbum("Atrapado en un sueño")
            ));
        }

        if ("Arcangel".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Sentimiento, Elegancia & Maldad",
                LocalDate.of(2013, 1, 15),
                "Reggaeton",
                "portada_sentimiento_elegancia_maldad.jpg",
                obtenerCancionesDeAlbum("Sentimiento, Elegancia & Maldad")
            ));
        }

        if ("Bizarrap".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "BZRP Music Sessions, Vol. 36",
                LocalDate.of(2020, 10, 22),
                "Trap",
                "portada_bzrp_36.jpg",
                obtenerCancionesDeAlbum("BZRP Music Sessions, Vol. 36")
            ));
        }

        if ("Babi".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Debut",
                LocalDate.of(2021, 6, 18),
                "Trap",
                "portada_debut.jpg",
                obtenerCancionesDeAlbum("Debut")
            ));
        }

        return albumes;
    }
    
    public static List<AlbumDTO> obtenerAlbumesDeBanda(ArtistaDTO artistaDTO) {
        List<AlbumDTO> albumes = new ArrayList<>();
        
        if ("Latin Mafia".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Latin Vibes",
                LocalDate.of(2015, 7, 15),
                "Pop",
                "portada_latin_vibes.jpg",
                obtenerCancionesDeAlbum("Latin Vibes")
            ));
        }

        if ("Zoe".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Reptilectric",
                LocalDate.of(2008, 10, 14),
                "Pop",
                "portada_reptilectric.jpg",
                obtenerCancionesDeAlbum("Reptilectric")
            ));
            albumes.add(new AlbumDTO(
                "Aztlán",
                LocalDate.of(2018, 3, 9),
                "Pop",
                "portada_aztlan.jpg",
                obtenerCancionesDeAlbum("Aztlán")
            ));
        }

        if ("Fuerza Regida".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Del Barrio Hasta Aquí",
                LocalDate.of(2019, 6, 14),
                "Regional",
                "portada_del_barrio_hasta_aqui.jpg",
                obtenerCancionesDeAlbum("Del Barrio Hasta Aquí")
            ));
        }

        if ("Reik".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Peligro",
                LocalDate.of(2011, 6, 21),
                "Pop Latino",
                "portada_peligro.jpg",
                obtenerCancionesDeAlbum("Peligro")
            ));
            albumes.add(new AlbumDTO(
                "Des/Amor",
                LocalDate.of(2016, 8, 12),
                "Pop Latino",
                "portada_desamor.jpg",
                obtenerCancionesDeAlbum("Des/Amor")
            ));
        }

        if ("Morat".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Balas Perdidas",
                LocalDate.of(2018, 10, 26),
                "Pop",
                "portada_balas_perdidas.jpg",
                obtenerCancionesDeAlbum("Balas Perdidas")
            ));
        }

        if ("Blackpink".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "The Album",
                LocalDate.of(2020, 10, 2),
                "K-Pop",
                "portada_the_album.jpg",
                obtenerCancionesDeAlbum("The Album")
            ));
        }

        if ("Maneskin".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Il Ballo Della Vita",
                LocalDate.of(2018, 10, 26),
                "Pop",
                "portada_il_ballo_della_vita.jpg",
                obtenerCancionesDeAlbum("Il Ballo Della Vita")
            ));
            albumes.add(new AlbumDTO(
                "Teatro d'ira: Vol. I",
                LocalDate.of(2021, 3, 19),
                "Pop",
                "portada_teatro_dira.jpg",
                obtenerCancionesDeAlbum("Teatro d'ira: Vol. I")
            ));
        }

        if ("Twenty One Pilots".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Blurryface",
                LocalDate.of(2015, 5, 17),
                "Hip Hop",
                "portada_blurryface.jpg",
                obtenerCancionesDeAlbum("Blurryface")
            ));
            albumes.add(new AlbumDTO(
                "Trench",
                LocalDate.of(2018, 10, 5),
                "Hip Hop",
                "portada_trench.jpg",
                obtenerCancionesDeAlbum("Trench")
            ));
        }

        if ("Arctic Monkeys".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "AM",
                LocalDate.of(2013, 9, 9),
                "Indie",
                "portada_am.jpg",
                obtenerCancionesDeAlbum("AM")
            ));
        }

        if ("KISS".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Destroyer",
                LocalDate.of(1976, 3, 15),
                "Rock",
                "portada_destroyer.jpg",
                obtenerCancionesDeAlbum("Destroyer")
            ));
        }

        if ("Keane".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Hopes and Fears",
                LocalDate.of(2004, 5, 10),
                "Rock",
                "portada_hopes_and_fears.jpg",
                obtenerCancionesDeAlbum("Hopes and Fears")
            ));
        }

        if ("Queen".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "A Night at the Opera",
                LocalDate.of(1975, 11, 21),
                "Rock",
                "portada_a_night_at_the_opera.jpg",
                obtenerCancionesDeAlbum("A Night at the Opera")
            ));
        }

        if ("Sin Bandera".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Sin Bandera",
                LocalDate.of(2001, 11, 20),
                "Bolero",
                "portada_sin_bandera.jpg",
                obtenerCancionesDeAlbum("Sin Bandera")
            ));
        }

        if ("Big Time Rush".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "BTR",
                LocalDate.of(2010, 10, 11),
                "Pop",
                "portada_btr.jpg",
                obtenerCancionesDeAlbum("BTR")
            ));
        }

        if ("One Direction".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Up All Night",
                LocalDate.of(2011, 11, 18),
                "Pop",
                "portada_up_all_night.jpg",
                obtenerCancionesDeAlbum("Up All Night")
            ));
        }
        
        if ("CD9".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "CD9",
                LocalDate.of(2013, 3, 3),
                "Pop",
                "portada_cd9.jpg",
                obtenerCancionesDeAlbum("CD9")
            ));
            albumes.add(new AlbumDTO(
                "Evolution",
                LocalDate.of(2015, 8, 28),
                "Pop",
                "portada_evolution.jpg",
                obtenerCancionesDeAlbum("Evolution")
            ));
        }

        if ("Plan B".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Love & Sex",
                LocalDate.of(2014, 2, 4),
                "Reggaeton",
                "portada_love_and_sex.jpg",
                obtenerCancionesDeAlbum("Love & Sex")
            ));
            albumes.add(new AlbumDTO(
                "House of Pleasure",
                LocalDate.of(2010, 3, 2),
                "Reggaeton",
                "portada_house_of_pleasure.jpg",
                obtenerCancionesDeAlbum("House of Pleasure")
            ));
        }

        if ("Enjambre".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Daltónico",
                LocalDate.of(2007, 11, 6),
                "Rock",
                "portada_daltonico.jpg",
                obtenerCancionesDeAlbum("Daltónico")
            ));
            albumes.add(new AlbumDTO(
                "Imperfecto Extraño",
                LocalDate.of(2013, 10, 29),
                "Rock",
                "portada_imperfecto_extrano.jpg",
                obtenerCancionesDeAlbum("Imperfecto Extraño")
            ));
        }

        if ("Banda MS".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Qué Bendición",
                LocalDate.of(2019, 10, 18),
                "Regional",
                "portada_que_bendicion.jpg",
                obtenerCancionesDeAlbum("Qué Bendición")
            ));
            albumes.add(new AlbumDTO(
                "Con Todas Las Fuerzas",
                LocalDate.of(2016, 2, 19),
                "Regional",
                "portada_con_todas_las_fuerzas.jpg",
                obtenerCancionesDeAlbum("Con Todas Las Fuerzas")
            ));
        }

        if ("MYA".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "MYA",
                LocalDate.of(2017, 6, 23),
                "Urbano",
                "portada_mya.jpg",
                obtenerCancionesDeAlbum("MYA")
            ));
        }

        if ("Deftones".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "White Pony",
                LocalDate.of(2000, 6, 20),
                "Rock",
                "portada_white_pony.jpg",
                obtenerCancionesDeAlbum("White Pony")
            ));
            albumes.add(new AlbumDTO(
                "Diamond Eyes",
                LocalDate.of(2010, 5, 4),
                "Rock",
                "portada_diamond_eyes.jpg",
                obtenerCancionesDeAlbum("Diamond Eyes")
            ));
        }

        if ("The neighbourhood".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "I Love You.",
                LocalDate.of(2013, 4, 22),
                "Pop",
                "portada_i_love_you.jpg",
                obtenerCancionesDeAlbum("I Love You.")
            ));
            albumes.add(new AlbumDTO(
                "Wiped Out!",
                LocalDate.of(2015, 10, 30),
                "Pop",
                "portada_wiped_out.jpg",
                obtenerCancionesDeAlbum("Wiped Out!")
            ));
        }

        if ("Grupo Frontera".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Pa' La Banda",
                LocalDate.of(2022, 3, 15),
                "Regional",
                "portada_pa_la_banda.jpg",
                obtenerCancionesDeAlbum("Pa' La Banda")
            ));
        }

        if ("Grupo Firme".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Nos Divertimos Logrando Lo Imposible",
                LocalDate.of(2020, 11, 6),
                "Regional",
                "portada_nos_divertimos.jpg",
                obtenerCancionesDeAlbum("Nos Divertimos Logrando Lo Imposible")
            ));
        }

        if ("The Walters".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Songs for Dads",
                LocalDate.of(2014, 6, 10),
                "Alternativo",
                "portada_songs_for_dads.jpg",
                obtenerCancionesDeAlbum("Songs for Dads")
            ));
        }

        if ("El cuarteto de nos".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Bipolar",
                LocalDate.of(2009, 8, 1),
                "Rock",
                "portada_bipolar.jpg",
                obtenerCancionesDeAlbum("Bipolar")
            ));
        }

        if ("Guns & Roses".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Appetite for Destruction",
                LocalDate.of(1987, 7, 21),
                "Rock",
                "portada_appetite_for_destruction.jpg",
                obtenerCancionesDeAlbum("Appetite for Destruction")
            ));
        }

        if ("RBD".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Rebelde",
                LocalDate.of(2004, 11, 11),
                "Indie",
                "portada_rebelde.jpg",
                obtenerCancionesDeAlbum("Rebelde")
            ));
        }
        
        return albumes;
    }

    public static List<CancionDTO> obtenerCancionesDeAlbum(String nombreAlbum) {
       List<CancionDTO> canciones = new ArrayList<>();

       switch (nombreAlbum) {
           case "Pies Descalzos":
               canciones.add(new CancionDTO("Estoy Aquí", "3:50", "Pop"));
               canciones.add(new CancionDTO("Pies Descalzos, Sueños Blancos", "3:37", "Pop"));
               canciones.add(new CancionDTO("Antología", "4:30", "Pop"));
               break;

           case "Laundry Service":
               canciones.add(new CancionDTO("Whenever, Wherever", "3:16", "Pop Rock"));
               canciones.add(new CancionDTO("Underneath Your Clothes", "4:12", "Pop Rock"));
               canciones.add(new CancionDTO("Objection (Tango)", "3:42", "Pop Rock"));
               break;

           case "James Arthur":
               canciones.add(new CancionDTO("Impossible", "3:42", "Pop"));
               canciones.add(new CancionDTO("You're Nobody 'Til Somebody Loves You", "3:59", "Pop"));
               break;

           case "You":
               canciones.add(new CancionDTO("Falling Like The Stars", "3:35", "Pop"));
               canciones.add(new CancionDTO("Empty Space", "3:40", "Pop"));
               break;

           case "Me Dejé Llevar":
               canciones.add(new CancionDTO("Adiós Amor", "3:20", "Norteña"));
               canciones.add(new CancionDTO("Te Fallé", "3:10", "Norteña"));
               break;

           case "Ahora":
               canciones.add(new CancionDTO("No Te Contaron Mal", "3:27", "Regional"));
               canciones.add(new CancionDTO("Se Me Olvidó", "3:15", "Regional"));
               break;

           case "Habla El Corazón":
               canciones.add(new CancionDTO("Ángel", "3:30", "Pop"));
               canciones.add(new CancionDTO("Ya Te Olvidé", "3:45", "Pop"));
               break;

           case "Nada Es Color De Rosa":
               canciones.add(new CancionDTO("Nada Es Color De Rosa", "3:22", "Pop"));
               canciones.add(new CancionDTO("No Me Preguntes", "3:35", "Pop"));
               break;

           case "Me siento viva":
               canciones.add(new CancionDTO("Todos Me Miran", "3:50", "Pop Latino"));
               canciones.add(new CancionDTO("El Favor De La Soledad", "4:00", "Pop Latino"));
               break;

           case "De Película":
               canciones.add(new CancionDTO("Vestida De Azúcar", "3:40", "Pop Latino"));
               canciones.add(new CancionDTO("Cinco Minutos", "3:55", "Pop Latino"));
               break;
               
            case "Belinda":
                canciones.add(new CancionDTO("Ángel", "3:33", "Pop"));
                canciones.add(new CancionDTO("Vuelve Conmigo", "3:21", "Pop"));
            break;
            
            case "Utopía":
                canciones.add(new CancionDTO("Bella Traición", "3:49", "Pop"));
                canciones.add(new CancionDTO("Luz Sin Gravedad", "3:46", "Pop"));
                break;
                
            case "Primera Estrella":
                canciones.add(new CancionDTO("Déjame Intentarlo", "3:20", "Pop Latino"));
                canciones.add(new CancionDTO("El Juego", "3:42", "Pop Latino"));
                break;
                
            case "Yours Truly":
                canciones.add(new CancionDTO("The Way", "3:41", "Pop"));
                canciones.add(new CancionDTO("Baby I", "3:38", "Pop"));
                break;
                
            case "Sweetener":
                canciones.add(new CancionDTO("No Tears Left to Cry", "3:26", "Pop"));
                canciones.add(new CancionDTO("God Is a Woman", "3:17", "Pop"));
                break;
                
            case "MAWZ":
                canciones.add(new CancionDTO("Mamichula", "3:30", "Trap"));
                canciones.add(new CancionDTO("Flexin'", "3:15", "Trap"));
                break;
                
            case "Homerun":
                canciones.add(new CancionDTO("Adán y Eva", "3:41", "Trap"));
                canciones.add(new CancionDTO("Tal Vez", "3:56", "Trap"));
                break;
                
            case "Animal":
                canciones.add(new CancionDTO("Acaramelao", "3:34", "Pop"));
                canciones.add(new CancionDTO("Mi Debilidad", "3:50", "Pop"));
                break;
                
            case "Atrevido":
                canciones.add(new CancionDTO("Atrevido", "3:40", "Trap"));
                canciones.add(new CancionDTO("Mamichula", "3:30", "Trap"));
                break;
                
            case "Recuerdos":
                canciones.add(new CancionDTO("Wapo Traketero", "3:28", "Hip Hop"));
                canciones.add(new CancionDTO("Colocao", "3:10", "Hip Hop"));
                break;
                
            case "Trapicheo":
                canciones.add(new CancionDTO("Loca", "3:20", "Trap"));
                canciones.add(new CancionDTO("Deja de Llorar", "3:35", "Trap"));
                break;
                
            case "Julio":
                canciones.add(new CancionDTO("Piénsalo", "3:15", "Rap"));
                canciones.add(new CancionDTO("Julio", "3:40", "Rap"));
                break;
                
            case "Para Siempre":
                canciones.add(new CancionDTO("Estos Celos", "3:45", "Regional"));
                canciones.add(new CancionDTO("Para Siempre", "3:57", "Regional"));
                break;
                
            case "Recuerdos, Vol. II":
                canciones.add(new CancionDTO("La Diferencia", "3:40", "Regional"));
                canciones.add(new CancionDTO("Si Quieres", "3:30", "Regional"));
                break;
                
            case "Secretos":
                canciones.add(new CancionDTO("Lo Pasado, Pasado", "3:55", "Bolero"));
                canciones.add(new CancionDTO("Almohada", "3:35", "Bolero"));
                break;
                
            case "Volcán":
                canciones.add(new CancionDTO("Volcán", "3:50", "Bolero"));
                canciones.add(new CancionDTO("La Nave del Olvido", "3:45", "Bolero"));
                break;
                
            case "Un Nuevo Amor":
                canciones.add(new CancionDTO("Eres Todo", "3:30", "Pop"));
                canciones.add(new CancionDTO("Tu Nombre", "3:25", "Pop"));
                break;
                
            case "Quiéreme Tal Como Soy":
                canciones.add(new CancionDTO("Quiéreme Tal Como Soy", "3:40", "Pop"));
                canciones.add(new CancionDTO("Por Tí", "3:45", "Pop"));
                break;
                
            case "Singular: Act I":
                canciones.add(new CancionDTO("Almost Love", "3:30", "Pop"));
                canciones.add(new CancionDTO("Sueña", "3:40", "Pop"));
                break;
                
            case "Singular: Act II":
                canciones.add(new CancionDTO("In My Bed", "3:35", "Pop"));
                canciones.add(new CancionDTO("Take Off", "3:50", "Pop"));
                break;
                
            case "Simetría":
                canciones.add(new CancionDTO("Simetría", "3:45", "Rap"));
                canciones.add(new CancionDTO("Tiempo", "3:30", "Rap"));
                break;
                
            case "Prisma":
                canciones.add(new CancionDTO("Me Llamas", "3:40", "Rap"));
                canciones.add(new CancionDTO("Demasiado Tarde", "3:50", "Rap"));
                break;
                
            case "Que Me Lleve El Diablo":
                canciones.add(new CancionDTO("Que Me Lleve El Diablo", "3:38", "Regional"));
                canciones.add(new CancionDTO("Llévame Contigo", "3:45", "Regional"));
                break;
                
            case "Alma Vacía":
                canciones.add(new CancionDTO("Alma Vacía", "3:40", "Regional"));
                canciones.add(new CancionDTO("De Ti Me Enamoré", "3:35", "Regional"));
                break;
                
            case "Be the Cowboy":
                canciones.add(new CancionDTO("Nobody", "3:55", "Indie"));
                canciones.add(new CancionDTO("Geyser", "3:40", "Indie"));
                break;
                
            case "Norman Fucking Rockwell!":
                canciones.add(new CancionDTO("Mariners Apartment Complex", "3:54", "Indie"));
                canciones.add(new CancionDTO("Venice Bitch", "9:39", "Indie"));
                break;
                
            case "Soul Urbano":
                canciones.add(new CancionDTO("Te Quiero", "3:38", "Pop"));
                canciones.add(new CancionDTO("Otra Vez", "3:42", "Pop"));
                break;
                
            case "Atrapado en un sueño":
                canciones.add(new CancionDTO("Atrapado en un sueño", "3:50", "Hip Hop"));
                canciones.add(new CancionDTO("La Última", "3:44", "Hip Hop"));
                break;
                
            case "Sentimiento, Elegancia & Maldad":
                canciones.add(new CancionDTO("Me Prefieres a Mí", "3:33", "Reggaeton"));
                canciones.add(new CancionDTO("Cuando Tú No Estás", "3:45", "Reggaeton"));
                break;
                
            case "BZRP Music Sessions, Vol. 36":
                canciones.add(new CancionDTO("BZRP Music Session #36", "3:30", "Trap"));
                break;
                
            case "Debut":
                canciones.add(new CancionDTO("Debut Song", "3:40", "Trap"));
                break;
                
            case "Latin Vibes":
                canciones.add(new CancionDTO("Ritmo Caliente", "3:50", "Pop"));
                canciones.add(new CancionDTO("Noche Sin Fin", "4:10", "Pop"));
            break;

            case "Reptilectric":
                canciones.add(new CancionDTO("Nada", "4:24", "Pop"));
                canciones.add(new CancionDTO("Luna", "3:30", "Pop"));
                break;

            case "Aztlán":
                canciones.add(new CancionDTO("Azul", "3:45", "Pop"));
                canciones.add(new CancionDTO("Somos", "3:56", "Pop"));
                break;

            case "Del Barrio Hasta Aquí":
                canciones.add(new CancionDTO("Del Barrio", "3:25", "Regional"));
                canciones.add(new CancionDTO("La Ultima Carta", "3:48", "Regional"));
                break;

            case "Peligro":
                canciones.add(new CancionDTO("Peligro", "3:50", "Pop Latino"));
                canciones.add(new CancionDTO("No Me Importa", "3:35", "Pop Latino"));
                break;

            case "Des/Amor":
                canciones.add(new CancionDTO("Me Niego", "3:45", "Pop Latino"));
                canciones.add(new CancionDTO("Ya Me Enteré", "3:40", "Pop Latino"));
                break;

            case "Balas Perdidas":
                canciones.add(new CancionDTO("Cuando Nadie Ve", "3:50", "Pop"));
                canciones.add(new CancionDTO("Presiento", "3:45", "Pop"));
                break;

            case "The Album":
                canciones.add(new CancionDTO("How You Like That", "3:01", "K-Pop"));
                canciones.add(new CancionDTO("Lovesick Girls", "3:32", "K-Pop"));
                break;

            case "Il Ballo Della Vita":
                canciones.add(new CancionDTO("Morirò da re", "3:41", "Pop"));
                canciones.add(new CancionDTO("Torna a casa", "4:13", "Pop"));
                break;

            case "Teatro d'ira: Vol. I":
                canciones.add(new CancionDTO("Zitti e buoni", "3:02", "Pop"));
                canciones.add(new CancionDTO("I Wanna Be Your Slave", "3:21", "Pop"));
                break;

            case "Blurryface":
                canciones.add(new CancionDTO("Stressed Out", "3:22", "Hip Hop"));
                canciones.add(new CancionDTO("Ride", "3:34", "Hip Hop"));
                break;

            case "Trench":
                canciones.add(new CancionDTO("Jumpsuit", "3:58", "Hip Hop"));
                canciones.add(new CancionDTO("Nico and the Niners", "3:55", "Hip Hop"));
                break;

            case "AM":
                canciones.add(new CancionDTO("Do I Wanna Know?", "4:32", "Indie"));
                canciones.add(new CancionDTO("R U Mine?", "3:21", "Indie"));
                break;

            case "Destroyer":
                canciones.add(new CancionDTO("Detroit Rock City", "5:16", "Rock"));
                canciones.add(new CancionDTO("Beth", "2:49", "Rock"));
                break;

            case "Hopes and Fears":
                canciones.add(new CancionDTO("Somewhere Only We Know", "3:58", "Rock"));
                canciones.add(new CancionDTO("Everybody's Changing", "3:36", "Rock"));
                break;

            case "A Night at the Opera":
                canciones.add(new CancionDTO("Bohemian Rhapsody", "5:55", "Rock"));
                canciones.add(new CancionDTO("You're My Best Friend", "2:50", "Rock"));
                break;

            case "Sin Bandera":
                canciones.add(new CancionDTO("Entra en Mi Vida", "4:10", "Bolero"));
                canciones.add(new CancionDTO("Kilómetros", "4:33", "Bolero"));
                break;

            case "BTR":
                canciones.add(new CancionDTO("Elevate", "3:14", "Pop"));
                canciones.add(new CancionDTO("Paralyzed", "3:31", "Pop"));
                break;

            case "Up All Night":
                canciones.add(new CancionDTO("What Makes You Beautiful", "3:19", "Pop"));
                canciones.add(new CancionDTO("Gotta Be You", "3:54", "Pop"));
                break;
            
            case "CD9":
                canciones.add(new CancionDTO("The Party", "3:40", "Pop"));
                canciones.add(new CancionDTO("Ángel Cruel", "3:35", "Pop"));
                break;
                
            case "Evolution":
                canciones.add(new CancionDTO("Solo Quédate En Silencio", "3:50", "Pop"));
                canciones.add(new CancionDTO("Más", "3:45", "Pop"));
                break;
                
            case "Love & Sex":
                canciones.add(new CancionDTO("Mi Vecinita", "3:35", "Reggaeton"));
                canciones.add(new CancionDTO("Es Un Secreto", "3:40", "Reggaeton"));
                break;
                
            case "House of Pleasure":
                canciones.add(new CancionDTO("Es Un Secreto", "3:30", "Reggaeton"));
                canciones.add(new CancionDTO("Si No Le Contesto", "3:25", "Reggaeton"));
                break;
                
            case "Daltónico":
                canciones.add(new CancionDTO("Manía Cardiaca", "4:10", "Rock"));
                canciones.add(new CancionDTO("Despacio", "3:55", "Rock"));
                break;
                
            case "Imperfecto Extraño":
                canciones.add(new CancionDTO("Cada Vez Que Estoy Sin Ti", "3:45", "Rock"));
                canciones.add(new CancionDTO("Aún", "3:50", "Rock"));
                break;
                
            case "Qué Bendición":
                canciones.add(new CancionDTO("Qué Bendición", "3:50", "Regional"));
                canciones.add(new CancionDTO("Solo Con Verte", "3:55", "Regional"));
                break;
                
            case "Con Todas Las Fuerzas":
                canciones.add(new CancionDTO("Tengo Que Colgar", "3:45", "Regional"));
                canciones.add(new CancionDTO("Me Vas a Extrañar", "3:50", "Regional"));
                break;
                
            case "MYA":
                canciones.add(new CancionDTO("Qué Rico Fuera", "3:30", "Urbano"));
                canciones.add(new CancionDTO("Nena Maldición", "3:40", "Urbano"));
                break;
                
            case "White Pony":
                canciones.add(new CancionDTO("Change (In the House of Flies)", "4:25", "Rock"));
                canciones.add(new CancionDTO("Digital Bath", "4:33", "Rock"));
                break;
                
            case "Diamond Eyes":
                canciones.add(new CancionDTO("Diamond Eyes", "4:15", "Rock"));
                canciones.add(new CancionDTO("Rocket Skates", "3:55", "Rock"));
                break;
                
            case "I Love You.":
                canciones.add(new CancionDTO("Sweater Weather", "4:00", "Pop"));
                canciones.add(new CancionDTO("Afraid", "3:50", "Pop"));
                break;
                
            case "Wiped Out!":
                canciones.add(new CancionDTO("Gnash", "3:45", "Pop"));
                canciones.add(new CancionDTO("Softcore", "3:55", "Pop"));
                break;
                
            case "Pa' La Banda":
                canciones.add(new CancionDTO("La Chona", "3:20", "Regional"));
                canciones.add(new CancionDTO("El Amor de Su Vida", "3:40", "Regional"));
                break;
                
            case "Nos Divertimos Logrando Lo Imposible":
                canciones.add(new CancionDTO("Cada Quién", "3:45", "Regional"));
                canciones.add(new CancionDTO("El Amor de Su Vida", "3:50", "Regional"));
                break;
                
            case "Songs for Dads":
                canciones.add(new CancionDTO("Goodbye", "3:40", "Alternativo"));
                canciones.add(new CancionDTO("New King", "3:35", "Alternativo"));
                break;
                
            case "Bipolar":
                canciones.add(new CancionDTO("Yendo a la Casa de Damián", "3:40", "Rock"));
                canciones.add(new CancionDTO("Cuando Seas Grande", "3:50", "Rock"));
                break;
                
            case "Appetite for Destruction":
                canciones.add(new CancionDTO("Welcome to the Jungle", "4:32", "Rock"));
                canciones.add(new CancionDTO("Sweet Child o' Mine", "5:56", "Rock"));
                break;
                
            case "Rebelde":
                canciones.add(new CancionDTO("Rebelde", "3:34", "Indie"));
                canciones.add(new CancionDTO("Solo Quédate En Silencio", "3:56", "Indie"));
                break;

           default:
               // Álbum no encontrado, lista vacía
               break;
        }

        return canciones;
    }

}
