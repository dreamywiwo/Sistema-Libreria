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

        artistasSolistas.add(new ArtistaDTO("Shakira", "Solista", "Pop", "https://imgs.search.brave.com/EMlmYV6S5eouI1bqzv12c6C1APC5jlRMPJbQZiQAFSs/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly82NC5t/ZWRpYS50dW1ibHIu/Y29tLzQ0NTgzYjA3/ZGI1NmM3ZjRkMDgz/N2FmZGUzNGNiYjRl/LzY4ZTFkY2UwMWY2/N2FmNDItYzkvczEy/ODB4MTkyMC8zMjUw/MGM0NjFiZjU1OWFm/MzZiZjlkMDk4Zjhi/ZGY5N2UxMjc0OGU5/LmpwZw"));
        artistasSolistas.add(new ArtistaDTO("James Arthur", "Solista", "Pop", "https://imgs.search.brave.com/xKn9zUIyUSfIDtyDQEqrROwiNc99rJ6_UxbSsjUrnWQ/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vX3A4ZTI4/T3c2c0tZYXY4alEw/WnpOQ3RhdjRCTUFV/a1k5eEZMVlNsaGlk/ay9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlq/Wkc0dC9jQzV6YldW/b2IzTjBMbTVsL2RD/OXphWFJsY3k4MVlq/TmkvWVdNMU9XVmlN/elkwTURFMi9PVFJo/WmpOaE1qUXhNVGN6/L05EUTNaaTkzY0Mx/amIyNTAvWlc1MEwz/VndiRzloWkhNdi9N/akF5TkM4d01TOUtZ/VzFsL2N5MUJjblJv/ZFhJdWFuQmwvWnc"));
        artistasSolistas.add(new ArtistaDTO("Christian Nodal", "Solista", "Norteña", "https://imgs.search.brave.com/GjAORbjEI0eCfjqSpMooQ6EpSevp5pxc4t5ZxnzVdmA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vbmZJaEox/cTl4clNGWVRGd0I2/VFl2ZVBvcnZKRDhm/Qkt5RXNDamE0MUpq/Zy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/WVd4cy9jR0Z3WlhK/allYUXVZMjl0L0wz/Y3ZablZzYkM4M0x6/Y3YvWXk4eE5Ua3dN/alExTFRJMi9OVEI0/TVRjNE1DMWtaWE5y/L2RHOXdMV2hrTFdO/b2NtbHovZEdsaGJp/MXViMlJoYkMxaS9Z/V05yWjNKdmRXNWtM/V2x0L1lXZGxMbXB3/Wnc"));
        artistasSolistas.add(new ArtistaDTO("Yuridia", "Solista", "Pop", "https://imgs.search.brave.com/4lT_CV5TpGzv5a4MeO7tm9bcZW846BUgufCGtb8wEAg/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20veng4bUhH/RVUtd2dKVXpQblBW/dmpqMnlibHZVRVRX/cWc1Vm4wMEFfUmxP/QS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlq/Wkc0dC9jQzV6YldW/b2IzTjBMbTVsL2RD/OXphWFJsY3k4eE5X/SXcvTkdKa01tUTJN/V00wTlRSai9ZV05s/WXpBeE1qZzBOMlkx/L1ptRm1OQzkzY0Mx/amIyNTAvWlc1MEwz/VndiRzloWkhNdi9N/akF4TlM4d09DOUtO/RUV4L01qRXhMVkl0/TXpBd2VESTEvTUM1/cWNHYw"));
        artistasSolistas.add(new ArtistaDTO("Gloria Trevi", "Solista", "Pop Latino", "https://imgs.search.brave.com/NPPsxDJDMrIB6J2PX_uQgsChH6OjEzZb5hmDM1tIirY/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vajF3cHdn/aUlIYXlDekprVnNE/Mlhxck16YWwtY0Qt/RlpuM3ZkTVNzcFBh/dy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9kbkowZUcx/aFp5NWpiMjB2L2My/bDBaUzloYzNObGRI/TXYvWm1sc1pYTXZN/VFUyTlRBMy9MMmRz/YjNKcFlWOTBjbVYy/L2FUZ3VMV1psWVhS/MWNtVmsvTG1wd1p3"));
        artistasSolistas.add(new ArtistaDTO("Belinda", "Solista", "Pop", "https://imgs.search.brave.com/o_rL3a3RPFMVejraNtrikNFYJ9uyyEpmlTnolwUULpw/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vb2FoUmg4/bGc5YWR0NFZlb3J3/ZUpvTUdIRlFTYzFl/M00xRUpMSzNQbGJL/cy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9aV3gxYm1s/MlpYSnpZV3d1L1ky/OXRMbTE0TDNKbGMy/bDYvWlhJdmRqSXZW/RWxFVTFoTC9RemRU/UWtGWk5VRklVbGd6/L1ZUUkNVMUpHUVRR/dWFuQm4vUDJGMWRH/ZzlNbVkzWm1Way9N/RGN4TWpFNU9UY3pZ/amxoL1lqVTBObVF3/TVdZeFpqUXovTUdW/aFpERm1NbU0zTkRR/eC9NamxoTmpNNU5E/UTJOR0V4L016azRN/V1l4WkRFNE1TWnov/YldGeWREMTBjblZs/Sm5kcC9aSFJvUFRN/M01DWm9aV2xuL2FI/UTlNalkz"));
        artistasSolistas.add(new ArtistaDTO("Humbe", "Solista", "Pop Latino", "https://imgs.search.brave.com/lY_ERvczXNjdSQri8KEWyQYlRnH4P4P01hjkSIVcfP0/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vOGRkNEFE/WDlxUDhpb2NyX1ph/TmJDVS1TZlEySU5t/T1M3Zk9tLU43Yllu/OC9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl0/TG0xbC9aR2xoTFdG/dFlYcHZiaTVqL2Iy/MHZhVzFoWjJWekww/a3YvTnpGUVJVbHdl/R0kwTVV3dS9hbkJu"));
        artistasSolistas.add(new ArtistaDTO("Ariana Grande", "Solista", "Pop", "https://imgs.search.brave.com/Tc3iLQoc3f1Z1RupN2i1uQCW1MJ81BjczmidvuQcEjk/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vUXFWYldf/Z1lvakFuaXlTV0VC/dEdidC1PMlpjVWkt/LTlrTUJRd0FRc2VV/by9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlw/YldGbi9aVzVsY3k1/bGJIQmhhWE11L1ky/OXRMM0psYzJsNlpY/SXYvZGpJdlQxaExO/ekkwTnpOUy9Sa2RE/TjA5VFdVUkxRMWxT/L1VFWkJVRmt1YW5C/blAyRjEvZEdnOU5q/TTFNMkk0TlRSaS9Z/VEl5WkdJeVlUQTRN/VEprL01qY3daV000/TUdNNE16bG0vWXpG/bU5tRXdNVEZtTnps/bC9OMkk0T0RsaE4y/VmxOell5L09UWTFN/VFJrTlNaM2FXUjAv/YUQwME1UUW1hR1Zw/WjJoMC9QVE14TVNa/emJXRnlkRDEwL2Nu/Vmw"));
        artistasSolistas.add(new ArtistaDTO("Lit Killah", "Solista", "Trap", "https://imgs.search.brave.com/Mo0sf9EgHMC5ZjnIFzG0T7cglcKJT1sfhj4T1Tf3N5k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vQ2pRbEFq/Y0RIYUlMb1d4UmNN/czltNlUydEJnXzQ2/U05XM0liYkhFU3pF/WS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9iR0Z1WVdO/cGIyNHVZMjl0L0xt/RnlMM0psYzJsNlpY/SXYvZGpJdmJHbDBM/V3RwYkd4aC9hQzF6/WlMxd2NtVnpaVzUw/L1lTMWxjM1JsTFhO/aFltRmsvYnkxbGJp/MWxiQzF0YjNacC9j/M1JoY2kxUlZrcEpO/a2RIL1YwazFTRWsx/U2xOV1NrdE0vTnpW/WFJsSkVRUzVxY0dj/Xy9ZWFYwYUQwNU1E/VmlNR0prL01HVXhN/R0V3WW1JMU5EWmov/T0RReU5UQTBPV016/WkRGaC9OR05pWXpn/eE5UZzRZMkZoL1pX/RmpPVE14WVdNd05E/SmwvWldVeE5ESTJZ/bVEzSm5kcC9aSFJv/UFRReU1DWm9aV2xu/L2FIUTlNamd3Sm5G/MVlXeHAvZEhrOU56/QW1jMjFoY25ROS9k/SEoxWlE"));
        artistasSolistas.add(new ArtistaDTO("Paulo Londra", "Solista", "Trap", "https://imgs.search.brave.com/skUIjmuvN4ziDi5FcljjTvA5RGxzUPw2qyWoKA1lHvU/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vWFVXVUJa/dVhMVXhtR1NOT0tF/aEhNUnNkUFB2alJN/ZzJPQ1RRRFZRUGxP/dy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9ZMjEwZGk1/amIyMHVZWEl2L2FX/MWhaMlZ1WlhOZmJt/OTAvYVdOcFlYTXZN/REUwTWpZMC9OREF3/TVRjME1UTXhNRGt3/L01TNTNaV0p3UDFC/aGRXeHYvWDB4dmJt/UnlZVjlsYzNSeS9a/VzVoWDNOMVgyNTFa/WFp2L1gwVlE"));
        artistasSolistas.add(new ArtistaDTO("Maria Becerra", "Solista", "Pop", "https://imgs.search.brave.com/CGCOmKx9I2zJ5EUGE4Gybdh5hcDuJBF9jHttWxvR1oI/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vWE5vc2Fp/QVpyRjNWLTRsLWNy/NUFJNUVvSnNDN1pZ/bTdkT3RaVE5vbEF3/dy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9ZMjEwZGk1/amIyMHVZWEl2L2FX/MWhaMlZ1WlhOZllY/SjAvYVhOMFlYTXZN/all3TkM1My9aV0p3/UDAxaGNpVkRNeVZC/L1JHRWxNakJDWldO/bGNuSmg"));
        artistasSolistas.add(new ArtistaDTO("Trueno", "Solista", "Trap", "https://imgs.search.brave.com/4op24vfE-Gm4LYulyz3xXZa4zZaZHN-qmj1L9OQKVnI/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vM19STHNV/YlVNTHFfeU1LbVpK/NDVSdzFuanZoUlVi/bE95YV81TXpYa2FZ/US9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlq/Wkc0dC9jQzV6YldW/b2IzTjBMbTVsL2RD/OXphWFJsY3k4MVlq/TmkvWVdNMU9XVmlN/elkwTURFMi9PVFJo/WmpOaE1qUXhNVGN6/L05EUTNaaTkzY0Mx/amIyNTAvWlc1MEwz/VndiRzloWkhNdi9N/akF5TkM4d01TOHhN/RFZqL05UVTRPUzB6/TmpBM0xUUmovWVRB/dFlqUXlZaTA1T1RO/bC9ZMlppWkdZeE9E/Z3VhbkJu"));
        artistasSolistas.add(new ArtistaDTO("Nicki Nicole", "Solista", "Hip Hop", "https://imgs.search.brave.com/i65WhEwsckUykgSkrXTn2ELOnC91eP0q_9LceM15jys/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vY0dhRFg4/aklZdjlQTDlVU2VM/Znh3NlcxdXljWVJ2/LWIxaHd1OHI5bERw/NC9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/WVd4cy9jR0Z3WlhK/allYUXVZMjl0L0wz/Y3ZablZzYkM4MEx6/VXYvT1M4eE5UazRO/VEl5TFRFNS9NakI0/TVRBNE1DMWtaWE5y/L2RHOXdMVEV3T0RC/d0xXNXAvWTJ0cExX/NXBZMjlzWlMxaS9Z/V05yWjNKdmRXNWtM/WEJvL2IzUnZMbXB3/Wnc"));
        artistasSolistas.add(new ArtistaDTO("Khea", "Solista", "Trap", "https://imgs.search.brave.com/4sh65XdL3zCot8yKDK5lbLb3o70-rinNaAWGr4rXgJA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vUS1CbVlN/ODhZekZQakRkT1pp/ZGFtQUNNSndSQkxI/QVRScjd1UEJqVXFx/SS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlw/YldGbi9aWE11YzJz/dGMzUmhkR2xqL0xt/TnZiUzlwYldGblpY/TXYvYldWa2FXRXZh/VzFuTDJOdi9iRE12/TWpBeU1URXhNVEV0/L01UYzFORE14TFRR/M05qRTUvTVM1cWNH/Yw"));
        artistasSolistas.add(new ArtistaDTO("Milo J", "Solista", "Rap", "https://imgs.search.brave.com/_7-iQ4h485EY-SQQYuYLTddUAsEqayM7Oy1BbBzqHE8/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vT3RPN0d3/UFZsMHpRTFMxSDk4/ZU80b1pyeG1nRk5H/emZ6bzBMOWtVc3pm/ay9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTls/ZUhSbC9jbTVoYkMx/d2NtVjJhV1YzL0xu/SmxaR1F1YVhRdlpu/SmwvYzJndFpYQXRi/V2xzYnkxcS9MVFV4/TVMxMk1DMXRlREEx/L2JUSnFXbGwxVFZG/MVlUQkwvYm1Kdk9I/VktSR3hzTlVSMy9j/MDFpVFZOM01teFZO/R1JhL2QybzRMbXB3/Wno5aGRYUnYvUFhk/bFluQW1jejFpTUdJ/Mi9aV0UyTlRaallU/QmxOR1V6L1pHVTNN/MkZqWVRreFlXVmsv/TlRSaU5qbGxOVGMz/TlRabQ"));
        
        artistasSolistas.add(new ArtistaDTO("Vicente Fernandez", "Solista", "Regional", "https://imgs.search.brave.com/9JAYJWxoLo4ee-IdBy-9VxvflHc8NA-vqPa9Si6c3-g/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vT2FNa0tV/eGZvekJCS2QyX1Vf/S3ZJXzI0ODNmX0No/NzhIX0R1ZUgtRXlr/MC9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl0/WldScC9ZUzVuWlhS/MGVXbHRZV2RsL2N5/NWpiMjB2YVdRdk1U/QTEvTVRNNE5USXhM/MlZ6TDJadi9kRzh2/YldsaGJXa3RiV1Y0/L2FXTmhiaTF6YVc1/blpYSXQvZG1salpX/NTBaUzFtWlhKdS9Z/VzVrWlhvdGNHVnla/bTl5L2JYTXRZWFF0/WVcxbGNtbGovWVc1/aGFYSnNhVzVsY3kx/aC9jbVZ1WVMxdmJp/MXZZM1J2L1ltVnlM/VEV3TFRJd01UQXQv/YVc0dWFuQm5QM005/TmpFeS9lRFl4TWla/M1BUQW1hejB5L01D/WmpQWGM1WDNrMVUx/WnYvWjBVM1RFeEpW/MFp0Vkc1VC9aRFZt/ZWsxMWQzUkJUR0Ux/L1RWbEhlVWh0ZEda/Q1RUZzk"));
        artistasSolistas.add(new ArtistaDTO("Jose Jose", "Solista", "Bolero", "https://imgs.search.brave.com/4Rgt0RcTlJkJrcHoem2xRVlKNQx4hwNE22TWXTpiRsc/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vb0x3ekVE/ZkFiSGlEOWcwYW5w/N29MY0dfejZ6RUhU/RlJWUExjOEQyV2d2/QS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/WVd4cy9jR0Z3WlhK/aFkyTmxjM011L1ky/OXRMMloxYkd3dk1q/VTQvTURJeE1DNXFj/R2M"));
        artistasSolistas.add(new ArtistaDTO("Lucero", "Solista", "Pop", "https://imgs.search.brave.com/i-8l8ZZlfleRrPY86McsafRI_EbZ0B4GDvuf4K_8w7Q/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vRkozdm5L/N0R4QW5MVkF2MkM5/TlU5V0xOekVOVlFJ/QUZLM3haNTF1Nmhj/RS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlz/ZFdObC9jbTh1WTI5/dExtMTRMMmx0L1p5/OWpaSE12YkhWalpY/SnYvTFRJd01UZ3Ri/V0Z6TFdWdS9ZVzF2/Y21Ga1lTNXFjR2M"));
        artistasSolistas.add(new ArtistaDTO("Sabrina Carpenter", "Pop", "Pop", "https://imgs.search.brave.com/rtyojhjvnW6bwNsR9eciTbcbz7rLRmqQ9X8vZ89l95I/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vYVhQalNs/aE1nS0hOR2dCQVFV/RXlqaTExTk10bnBm/Tjg5RHQxVkV5emhJ/RS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkx/Ym1sMi9aWEp6WVd4/dGRYTnBZMjl1L2JH/bHVaUzVsY3k5alpH/NHYvYzJodmNDOW1h/V3hsY3k5VC9ZV0p5/YVc1aExVTmhjbkJs/L2JuUmxjaTFUYVc1/bmRXeGgvY2kxQlkz/UXRTUzFRYjNKMC9Z/V1JoTG1wd1p6OTJQ/VEUzL016ZzNORGc1/TnpjbWQybGsvZEdn/OU5UTXo"));
        artistasSolistas.add(new ArtistaDTO("Fufu", "Solista", "Rap", "https://imgs.search.brave.com/vhgbuGQO7aSf-QT85DI9VQAl3IjToQqxXAOFyA6e4Og/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vY2VFSmN5/SkY3WGVVNFhnOUN4/RzdjUV9hZXlHUU9k/cmxpRnpEX0hXdmUx/ay9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlz/WVhScC9ibTl6ZFc1/cFpHOXpiMjVzL2FX/NWxMbU52YlM5M2ND/MWovYjI1MFpXNTBM/M1Z3Ykc5aC9aSE12/TWpBeU1pOHdOeTlH/L1ZVWlZMVU5QVFZC/TU1VTkIvUkU4dFEw/OVdSVkl1Y0c1bg"));
        artistasSolistas.add(new ArtistaDTO("Beret", "Solista", "Rap", "https://imgs.search.brave.com/7sIlWCNEeOl8MNeuE97Our4sXQ2f1GBcpgb9OaF_7Ls/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vaVR2SEt1/ZHUxR1ZKNVlPTGpM/WlVaeGhuYzRrT3Z3/NlY5dmlDNno4Vkhu/US9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl5/WlhacC9jM1JoWm14/cGNHRnlMbU52L2JT/OTNjQzFqYjI1MFpX/NTAvTDNWd2JHOWha/SE12TWpBeS9OQzh3/T0M5Q1pYSmxkQzFD/L2RXVnViM010UVds/eVpYTXQvTWpBeU5D/MHhNVFUxZURjMy9N/QzVxY0dj"));
        artistasSolistas.add(new ArtistaDTO("Adrian L Santos", "Solista", "Regional", "https://imgs.search.brave.com/5RZvEtGK403ww5fdPop6_DNtPVoKps7o9-THBLqt3dY/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vSTFtWHBp/YW5nX0FNSGVIYXE4/bW9TV0hNNFNaMkFs/TW41MkpJY1JGX1Y1/OC9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlp/YjI5ci9hVzVuWVdk/bGJuUnBibVp2L0xt/TnZiUzkzY0MxamIy/NTAvWlc1MEwzVndi/RzloWkhNdi9NakF5/TkM4d01TOWhZalkz/L05qRTJNVEF3TURC/bE5XVmkvTlRrMk9H/Um1PVEE0WlRVMi9P/REJpWlRjd1kyTXlO/REprL0xURXRNalV3/ZURNd01DNXEvY0dj"));
        artistasSolistas.add(new ArtistaDTO("Ivan Cornejo", "Solista", "Regional", "https://imgs.search.brave.com/dwUgw6yj36trpPxj08q0I9XxxgqIdctqg9WR8uQu8lo/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vMVBEd3B3/V2JuVXdWQnJ4amNp/SVNBZHFOLUFiVC1N/SFZDcC1wWEI4bmtJ/QS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9ZbWxzYkdK/dllYSmtMbU52L2JT/OTNjQzFqYjI1MFpX/NTAvTDNWd2JHOWha/SE12TWpBeS9NUzh4/TVM5cGRtRnVMV052/L2NtNWxhbTh0Y0hK/bGMzTXQvTWpBeU1T/MWlhV3hzWW05aC9j/bVF0TVRVd01DMHhO/ak0yL05qVTJOREk1/TG1wd1p6OTMvUFRr/ME1pWm9QVFl5TXla/ai9jbTl3UFRF"));
        artistasSolistas.add(new ArtistaDTO("Mitski", "Solista", "Indie", "https://imgs.search.brave.com/M4R1EnksM0p_w_XRFmG5ofyzkQI3nQxxCDGxLo3SAzg/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vZHk2OUJH/UmFEMm1pc3lBSTQt/LVNFQTBiWXllNWZI/OUtPTnk4TE0tZGlT/OC9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlw/YldjdS9jR0Z6ZEdW/dFlXZGhlbWx1L1pT/NWpiMjB2ZDNBdFky/OXUvZEdWdWRDOTFj/R3h2WVdSei9Mekl3/TWpRdk1ESXZNalF4/L016STRNalF2T1Rn/NVF6VkYvUmpNdE9V/WkdNQzAwTmpFNC9M/VGcyTmtZdE56azFP/RVpEL1JrSkNOVGsx/TG1wd1pXYw"));
        artistasSolistas.add(new ArtistaDTO("Lana del Rey", "Solista", "Indie", "https://imgs.search.brave.com/15j6bPFs20B8KZzIi5M3UXYjAf3HllHHtpckrCDZ_wM/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vbkEzYnpj/cFo0NUxCcnRMblgz/OFdxcXJnODZDQ2Zp/SV9nTlE4eGFTQUdw/QS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9hRzl5YVhw/dmJuTnRkWE5wL1l5/NWpieTUxYXk5alpH/NHYvYzJodmNDOW1h/V3hsY3k4eC9Yek5q/WmpVNVkyVmlMV1Zo/L09EVXROR1EzTlMw/NE9URTAvTFRsaVl6/VmxOalF3TURZNC9N/UzVxY0djX2RqMHhO/amczL05qazNPVEkw/Sm5kcFpIUm8vUFRV/ek13"));
        artistasSolistas.add(new ArtistaDTO("Alex Ponce", "Solista", "Pop", "https://imgs.search.brave.com/sBb9fpi15YnOyvGyhPqJPAbzxRry2fDmZ17SOIu1HCI/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vX3ZNVVA3/VkZCQlRyTTdJWERJ/cFNNdkJYWlNtRWc3/bzVMYW5wOVNFOWJp/VS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlq/Wkc0dS9jSEp2WkM1/M1pXSnphWFJsL0xX/WnBiR1Z6TG1OdmJT/ODIvTkdVMk16SmxN/V0V3TjJJNS9Zak0x/TXpZME5Ua3dZalV2/L05qWTNZak15TkdR/eVpqUTIvWldaaVpq/RmxObUV6T1dZeC9Y/MEZzWlhnbE1qQlFi/MjVqL1pTd2xNakJo/Y25ScGMzUWwvTWpC/aWFXOHNKVEl3Y0hK/di9abWxzWlM1aGRt/bG0"));
        artistasSolistas.add(new ArtistaDTO("Junior H", "Solista", "Hip Hop", "https://imgs.search.brave.com/_VEHtBXdQ_6n4WCjpig0aeMfDnhJcKisRoaBZ3DY88o/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vUmIteVRj/TWdVQW5HcWVQQ1NC/TElEYnFZMWdFSFBO/SlF4Xy0xRmlUVFU5/cy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl1/YkhSeS9ZWFpsYkM1/ek15NTFjeTFsL1lY/TjBMVEl1WVcxaGVt/OXUvWVhkekxtTnZi/UzkzY0Mxai9iMjUw/Wlc1MEwzVndiRzlo/L1pITXZNakF5TXk4/d05pOHcvTWpFeU16/UXlPUzlLVlU1Si9U/MUl0U0M1d2JtYw"));
        artistasSolistas.add(new ArtistaDTO("Arcangel", "Solista", "Reggaeton", "https://imgs.search.brave.com/K2SSjfYVhDwfxHPj51OfaB-MOZEvQ08TfYqPn2UtJAc/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20valRmcDgz/dFd1S2NMRDNWV2lF/YmRscU51TEwySTVV/MDRPS0NaTE9uQWVp/dy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9ZMjEwZGk1/amIyMHVZWEl2L2FX/MWhaMlZ1WlhOZllY/SjAvYVhOMFlYTXZN/ekUxTXk1My9aV0p3/UDBGeVl5VkRNeVZC/L01XNW5aV3c"));
        artistasSolistas.add(new ArtistaDTO("Bizarrap", "Solista", "Trap", "https://imgs.search.brave.com/wFJ4a8oKjS8R1R1ijWHx8n6S0EFNElElY4LklLPbihI/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vYWJiNUlU/SDBoT2NwdXFTaDBW/UThRMElsQWN2Qzdf/a3ktOTdqaGo2SXFU/dy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9aV3gxYm1s/MlpYSnpZV3d1L1ky/OXRMbTE0TDNKbGMy/bDYvWlhJdmRqSXZS/RGRWV1VoWi9UalZD/VGtKT1NFUTFXa3hG/L1FrVlJWMVJHVjBV/dWFuQm4vUDJGMWRH/ZzlObVpoWkRSai9O/RGRtT1ROalltSTBO/R1poL056TXhZek16/TldJNE5HUTIvWW1J/eU56Z3lPVGN6T1RF/MC9ZVFU1TnpFME4y/Wm1abU0yL1l6SXlN/alEyTlRrelppWnov/YldGeWREMTBjblZs/Sm5kcC9aSFJvUFRF/eE1EQW1hR1ZwL1oy/aDBQVFkyTmc"));
        artistasSolistas.add(new ArtistaDTO("Babi", "Solista", "Trap", "https://imgs.search.brave.com/QbEJ9F2nYDK2H9d89J2R4gSysp1d1YSZtEKjuSFB2dk/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vVDJjYk8t/UGZpQUw4MktmMDB4/TzFhOFJIaEl3Qjhz/Wk5TT2o0bW92eGFh/US9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlw/TG0xMS9jMmxqWVds/dFp5NWpiMjB2L2JH/VjBjbUZ6THpJMU1I/Z3kvTlRBdlltRmlh/UzVxY0dj"));

        return artistasSolistas;
    }

    public static List<ArtistaDTO> obtenerBandas() {
        List<ArtistaDTO> bandas = new ArrayList<>();
        
        List<IntegranteDTO> integrantesLatinMafia = new ArrayList<>();
        integrantesLatinMafia.add(new IntegranteDTO("Juan Pérez", "Vocalista", LocalDate.of(2010, 1, 10), "Activo"));
        integrantesLatinMafia.add(new IntegranteDTO("Carlos López", "Guitarrista", LocalDate.of(2010, 1, 10), "Activo"));
        integrantesLatinMafia.add(new IntegranteDTO("Miguel Sánchez", "Bajista", LocalDate.of(2010, 1, 10), "Activo"));
        bandas.add(new ArtistaDTO("Latin Mafia", "Banda", "Pop", "https://imgs.search.brave.com/stHRVTN0PsRvNMqV2_q-uqIoktkjsgPvy1u7lMqvnck/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vX0lfM2RW/Q05YdUItZnBjWmdI/cmJPMmZ3SWNOdlVx/bGhRMFd5anRRZlZK/OC9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlq/WVMxMC9hVzFsY3k1/aWNtbG5hSFJ6L2NH/OTBZMlJ1TG1OdmJT/OWsvYVcxek5DOWta/V1poZFd4MC9MMlE1/WVdVME1ERXZNakUw/L056UTRNelkwTnk5/emRISnAvY0M5MGNu/VmxMMk55YjNBdi9O/RFkzTW5nME5qY3lL/ekFyL056UTFMM0ps/YzJsNlpTOHgvTURB/d2VERXdNREFoTDNG/MS9ZV3hwZEhrdk56/VXZQM1Z5L2JEMW9k/SFJ3Y3pvdkwyTmgv/YkdsbWIzSnVhV0V0/ZEdsdC9aWE10WW5K/cFoyaDBjM0J2L2RD/NXpNeTVoYldGNmIy/NWgvZDNNdVkyOXRM/ekZtTDJVNC9Memc1/WkdOak5tVTJOREF4/L01qazNPRE5tWVRB/eU5qSTUvT1dZNE1E/QXZiR0V0WkdVdC9i/Rzl6TFd4aGRHbHVM/VzFoL1ptbGhMV2ho/Ym1SdmRYUnovTFRN/dWFuQm4", integrantesLatinMafia));
        
        List<IntegranteDTO> integrantesZoe = new ArrayList<>();       
        integrantesZoe.add(new IntegranteDTO("Sergio Vega", "Bajista", LocalDate.of(1997, 1, 1), "Activo"));
        integrantesZoe.add(new IntegranteDTO("Cruz Martínez", "Guitarrista", LocalDate.of(1997, 1, 1), "Activo"));
        integrantesZoe.add(new IntegranteDTO("Ángel Mosqueda", "Batería", LocalDate.of(1997, 1, 1), "Activo"));
        integrantesZoe.add(new IntegranteDTO("León Larregui", "Vocalista", LocalDate.of(1997, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Zoe", "Banda", "Pop", "https://imgs.search.brave.com/7az1poaSNzR_2ofTUz1TrcomJajyvDHxxxgz_U16JL4/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vSFI5dDhE/dmVZQkE5dmNwUlhW/QWJZRnlvb1ppcFN2/Tzl0VndNdWhhVnVC/SS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9ibVZ2TWk1/amIyMHZkM0F0L1ky/OXVkR1Z1ZEM5MWNH/eHYvWVdSekx6SXdN/akV2TURVdi9XbTls/TFcxbGVHbGpieTF5/L2IyTnJMVzUxWlha/dkxXUnAvYzJOdkxX/VnVkSEpsZG1sei9k/R0V0Wm05MGJ5MHlM/bXB3L1p3", integrantesZoe));
        
        List<IntegranteDTO> integrantes3AM = new ArrayList<>();
        integrantes3AM.add(new IntegranteDTO("Emmanuel Loza", "Vocalista", LocalDate.of(2000, 1, 1), "Activo"));
        integrantes3AM.add(new IntegranteDTO("Luis Miguel Martínez", "Guitarrista", LocalDate.of(2000, 1, 1), "Activo"));
        integrantes3AM.add(new IntegranteDTO("Alfredo Herrera", "Batería", LocalDate.of(2000, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("3AM", "Banda", "Urbano", "https://imgs.search.brave.com/i1LXG2wGWrFWUOQ6bgBW1omZ1UhoQARrSGZTX9aztK0/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20valBXR2NE/dkRoVEF2SE5aaWJ0/LW9PVGZQUnRmVDRk/YndXV2dvMkRQWGh4/WS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlz/WVhOMC9abTB1Wm5K/bFpYUnNjeTVtL1lY/TjBiSGt1Ym1WMEwy/a3YvZFM5aGRtRjBZ/WEl4TnpCei9MMlE1/TWpBM05EZGxNMkky/L056QmtOMlEzT1RJ/eU1qSXcvWmpVMlpH/UTNOemd6", integrantes3AM));
        
        List<IntegranteDTO> integrantesFuerzaRegida = new ArrayList<>();
        integrantesFuerzaRegida.add(new IntegranteDTO("Javier Fernández", "Vocalista", LocalDate.of(2010, 1, 1), "Activo"));
        integrantesFuerzaRegida.add(new IntegranteDTO("Eduardo López", "Acordeonista", LocalDate.of(2010, 1, 1), "Activo"));
        integrantesFuerzaRegida.add(new IntegranteDTO("Mario García", "Bajista", LocalDate.of(2010, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Fuerza Regida", "Banda", "Regional", "https://imgs.search.brave.com/rhWVbWK5SPmnIf5O9Zm4hs3ZwJWvKEP5aAYJslh-QeI/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vWUwzRU92/d2JETTVqUHlMNHlv/SlN4bEplTzNzVC1j/NklBVzh4eXZDbTNQ/Zy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9jMjk1WjNK/MWNHVnlieTVqL2Iy/MHViWGd2ZDNBdFky/OXUvZEdWdWRDOTFj/R3h2WVdSei9Mekl3/TWpNdk1ETXZablZs/L2NucGhMWEpsWjJs/a1lTMXAvYm5SbFoz/SmhiblJsY3k1cS9j/R2M", integrantesFuerzaRegida));
        
        List<IntegranteDTO> integrantesReik = new ArrayList<>();
        integrantesReik.add(new IntegranteDTO("Jesús Navarro", "Vocalista", LocalDate.of(2003, 1, 1), "Activo"));
        integrantesReik.add(new IntegranteDTO("Julio Ramírez", "Guitarrista", LocalDate.of(2003, 1, 1), "Activo"));
        integrantesReik.add(new IntegranteDTO("Gilberto Marín", "Tecladista", LocalDate.of(2003, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Reik", "Banda", "Pop Latino", "https://imgs.search.brave.com/vk9vEV-KWsRkDfmGAfLZagIL_n8L0HG6PDKyotRV2_s/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vRGFvLW5w/SWlkTVZkR0NEd1ky/ZThzUGFoZ3JuWnhh/NThzcGVwY0RxQXpj/MC9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9ZMjEwZGk1/amIyMHVZWEl2L2FX/MWhaMlZ1WlhOZmJt/OTAvYVdOcFlYTXZN/RE15TXpJeC9NakF3/TVRjME1EUXhPREkz/L055NTNaV0p3UDA1/MVpYWnYvWDNSbGJX/RmZaR1ZmVW1WcC9h/dw", integrantesReik));
        
        List<IntegranteDTO> integrantesMorat = new ArrayList<>();
        integrantesMorat.add(new IntegranteDTO("Juan Pablo Isaza", "Vocalista/Guitarra", LocalDate.of(2015, 1, 1), "Activo"));
        integrantesMorat.add(new IntegranteDTO("Simón Vargas", "Bajo", LocalDate.of(2015, 1, 1), "Activo"));
        integrantesMorat.add(new IntegranteDTO("Martín Vargas", "Batería", LocalDate.of(2015, 1, 1), "Activo"));
        integrantesMorat.add(new IntegranteDTO("Alejandro Posada", "Guitarra", LocalDate.of(2015, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Morat", "Banda", "Pop", "https://imgs.search.brave.com/ugMO36j0qQQwl8iIOu70ngWWDAfBD61GrMCemyS3tJ8/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vckN3d1NU/UFBodHQycF9EV3lV/bmFKcl9rU2s4STQw/SklyTllIZ3Y2bHpB/NC9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlw/YldGbi9aWE11ZEc5/dFlYUnBZMnRsL2RD/NWpiMjB2WVhKMGFY/TjAvWVM4eU1ESXRi/Vzl5WVhRdS9hbkJs/Wnc", integrantesMorat));
        
        List<IntegranteDTO> integrantesBlackpink = new ArrayList<>();
        integrantesBlackpink.add(new IntegranteDTO("Jisoo", "Vocalista", LocalDate.of(2016, 8, 8), "Activo"));
        integrantesBlackpink.add(new IntegranteDTO("Jennie", "Rapper/Vocalista", LocalDate.of(2016, 8, 8), "Activo"));
        integrantesBlackpink.add(new IntegranteDTO("Rosé", "Vocalista", LocalDate.of(2016, 8, 8), "Activo"));
        integrantesBlackpink.add(new IntegranteDTO("Lisa", "Bailarina/Rapper", LocalDate.of(2016, 8, 8), "Activo"));
        bandas.add(new ArtistaDTO("Blackpink", "Banda", "K-Pop", "https://imgs.search.brave.com/xEMjBrzfTB6kr8HYYEgEeEytlmBGrsQOFkKTHIdmNj4/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vZlBmQ0lr/TUJ2akhuWmVMandP/dHMyWmJYRURZaWZ0/RFFJRnJPY1A4aktL/SS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkw/YzJodi9jQzV5TVRC/ekxtcHdMMkp2L2Iy/c3ZZMkZpYVc1bGRD/OHcvTnprNUx6UTVP/RGd3TXpFei9OVEEz/T1RrdWFuQm5QMlpw/L2RHbHVQVEkzTlRv/eU56VQ", integrantesBlackpink));
        
        List<IntegranteDTO> integrantesKevinKaarl = new ArrayList<>();
        integrantesKevinKaarl.add(new IntegranteDTO("Kevin Kaarl", "Vocalista/Guitarra", LocalDate.of(2018, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Kevin Kaarl", "Banda", "Indie", "https://imgs.search.brave.com/B0XaeXYxDx2SXXkrz6AfO6yMbE3PU7yo8gsBpM6-j6A/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vOHlrelln/TzVmNFNoaHQ2dF9s/R3JFaEZQRXVyRUJT/ZGR6Vm5WNHV2S2k1/WS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlw/Ym1ScC9aWEp2WTJ0/ekxuTm1iek11L1pH/bG5hWFJoYkc5alpX/RnUvYzNCaFkyVnpM/bU52YlM5My9jQzFq/YjI1MFpXNTBMM1Z3/L2JHOWhaSE12TWpB/eU1DOHgvTWk5TFpY/WnBiaTFMWVdGeS9i/Rjl4WlhsMGNXRjBM/bXB3L1pXYw", integrantesKevinKaarl));
        
        List<IntegranteDTO> integrantesManeskin = new ArrayList<>();
        integrantesManeskin.add(new IntegranteDTO("Damiano David", "Vocalista", LocalDate.of(2016, 1, 1), "Activo"));
        integrantesManeskin.add(new IntegranteDTO("Victoria De Angelis", "Bajista", LocalDate.of(2016, 1, 1), "Activo"));
        integrantesManeskin.add(new IntegranteDTO("Thomas Raggi", "Guitarrista", LocalDate.of(2016, 1, 1), "Activo"));
        integrantesManeskin.add(new IntegranteDTO("Ethan Torchio", "Batería", LocalDate.of(2016, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Maneskin", "Banda", "Pop", "https://imgs.search.brave.com/LYxnVeHnsT9jOeESvPxJD2aPSBdgq0_gf7QQpfBA0SA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vMmV1czJv/X0NxdlRnc002c2dE/bDBiNGVEcDZoV095/R3djVzd5OU5Ob0R1/MC9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl0/TG0xbC9aR2xoTFdG/dFlYcHZiaTVqL2Iy/MHZhVzFoWjJWekww/a3YvTmpGQ2NqaFVa/bVJoY1V3dS9hbkJu", integrantesManeskin));
        
        List<IntegranteDTO> integrantesTOP = new ArrayList<>();
        integrantesTOP.add(new IntegranteDTO("Tyler Joseph", "Vocalista/Teclado", LocalDate.of(2009, 1, 1), "Activo"));
        integrantesTOP.add(new IntegranteDTO("Josh Dun", "Batería", LocalDate.of(2011, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Twenty One Pilots", "Banda", "Hip Hop", "https://imgs.search.brave.com/M964y-zSM_rEiLhXDY_5lz92cn2SUa-_1lrUedtxgRk/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vRXpQUVE5/YXZweDBkQVptVV9h/Z21GTGdzc2NIYzdP/SWdSb0NQMzJvSWFI/NC9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl0/TG0xbC9aR2xoTFdG/dFlYcHZiaTVqL2Iy/MHZhVzFoWjJWekww/Y3YvTURFdlRYVnph/V05RY205bi9jbUZ0/YldsdVp5OHdOVEV3/L01qUmZWVk5GVGw5/QmNuUnAvYzNSVGRH/RjBhVzl1YzE5VS9k/MlZ1ZEhsUGJtVlFh/V3h2L2RITmZVRWRm/VUVGZlJVZGYvTWpR/d01IZ3lOREF3TG1w/dy9adw", integrantesTOP));
        
        List<IntegranteDTO> integrantesArcticMonkeys = new ArrayList<>();
        integrantesArcticMonkeys.add(new IntegranteDTO("Alex Turner", "Vocalista/Guitarrista", LocalDate.of(2002, 1, 1), "Activo"));
        integrantesArcticMonkeys.add(new IntegranteDTO("Jamie Cook", "Guitarrista", LocalDate.of(2002, 1, 1), "Activo"));
        integrantesArcticMonkeys.add(new IntegranteDTO("Nick O'Malley", "Bajista", LocalDate.of(2006, 1, 1), "Activo"));
        integrantesArcticMonkeys.add(new IntegranteDTO("Matt Helders", "Batería", LocalDate.of(2002, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Arctic Monkeys", "Banda", "Indie", "https://imgs.search.brave.com/IwU3CSrJ4BqowXTQJ3HgTfSlQ3I8Qeq32vdtJxo-pTM/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vcHpIYmNs/cU9oalVXX0RpQ2gz/UmdZc3N3dHZTVFpX/S3p1d1RONUFZbUNZ/Yy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlt/ZVdSdS9MbWx0WjJs/NExtNWxkQzl0L0wy/ZGxiaTloY25RdGNI/SnAvYm5RdGMzUmtM/WEJ2Y25SeS9ZV2ww/TFdaeVlXMWxaQzFp/L2JHRmpheTg1WWpn/NFlUVmwvTXkxak56/STJMVFF5WmprdC9Z/akkwTmkwd056WmhZ/Mll5L1lURXdNR0l1/YW5CblAyRjEvZEc4/OVptOXliV0YwTEdO/di9iWEJ5WlhOekpu/RTlOVEFtL2R6MHlP/REE", integrantesArcticMonkeys));
        
        List<IntegranteDTO> integrantesKiss = new ArrayList<>();
        integrantesKiss.add(new IntegranteDTO("Paul Stanley", "Vocalista/Guitarrista", LocalDate.of(1973, 1, 1), "Activo"));
        integrantesKiss.add(new IntegranteDTO("Gene Simmons", "Bajista/Vocalista", LocalDate.of(1973, 1, 1), "Activo"));
        integrantesKiss.add(new IntegranteDTO("Eric Singer", "Batería", LocalDate.of(1991, 1, 1), "Activo"));
        integrantesKiss.add(new IntegranteDTO("Tommy Thayer", "Guitarrista", LocalDate.of(2002, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("KISS", "Banda", "Rock", "https://imgs.search.brave.com/L11-1g4xm-hGC8IKi_4QlSlIAyd8BOkV2SxZz2kfp2s/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vLVFETzds/SVI3Y0pyZGRYVnFD/YjNlVmRRVzRnaEMz/cko3Zlphcy1VN0xq/cy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlw/YldGbi9aWE10Ym1F/dWMzTnNMV2x0L1lX/ZGxjeTFoYldGNmIy/NHUvWTI5dEwybHRZ/V2RsY3k5Si9Mell4/VldadVVGSnpWRzlN/L0xtcHdadw", integrantesKiss));
        
        List<IntegranteDTO> integrantesKeane = new ArrayList<>();
        integrantesKeane.add(new IntegranteDTO("Tom Chaplin", "Vocalista", LocalDate.of(1995, 1, 1), "Activo"));
        integrantesKeane.add(new IntegranteDTO("Tim Rice-Oxley", "Tecladista", LocalDate.of(1995, 1, 1), "Activo"));
        integrantesKeane.add(new IntegranteDTO("Richard Hughes", "Batería", LocalDate.of(1995, 1, 1), "Activo"));
        integrantesKeane.add(new IntegranteDTO("Jesse Quin", "Bajista", LocalDate.of(2007, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Keane", "Banda", "Rock", "https://imgs.search.brave.com/WMUIeG0xP--lljWrEiHDt77QDBymBgdDwWB3R7Ds4kY/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vU0RqOXNp/LVdQbTRlVTRVaEoy/Nnp2RVU1ZDJqQmpU/R1pncWFCaXN0aGVq/cy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlp/Ykc5bi9MblJwWTJ0/bGRHMWhjM1JsL2Np/NWtaUzkzY0MxamIy/NTAvWlc1MEwzVndi/RzloWkhNdi9NakF5/TXk4d09TOXJaV0Z1/L1pTMXJiMlZzYmkx/cmIyNTYvWlhKMExU/SXdNalF0ZEdsai9h/MlYwY3kxMmIzSjJa/WEpyL1lYVm1MV1Js/WW5WMExXRnMvWW5W/dExXZGxZblZ5ZEhO/MC9ZV2N1YW5Cbg", integrantesKeane));
        
        List<IntegranteDTO> integrantesQueen = new ArrayList<>();
        integrantesQueen.add(new IntegranteDTO("Freddie Mercury", "Vocalista", LocalDate.of(1970, 1, 1), "Fallecido"));
        integrantesQueen.add(new IntegranteDTO("Brian May", "Guitarrista", LocalDate.of(1970, 1, 1), "Activo"));
        integrantesQueen.add(new IntegranteDTO("Roger Taylor", "Batería", LocalDate.of(1970, 1, 1), "Activo"));
        integrantesQueen.add(new IntegranteDTO("John Deacon", "Bajista", LocalDate.of(1970, 1, 1), "Retirado"));
        bandas.add(new ArtistaDTO("Queen", "Banda", "Rock", "https://imgs.search.brave.com/99Jsie-ZZUuu6Qaku1svkgsSXz7fI9c91FjLfEj6F0M/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vU0duQ0ph/angxWE5uSFJNb2p3/Y0VEeWJtUklxdTUy/ZWV2ZDd1a2JVdTFS/RS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl0/TG0xbC9aR2xoTFdG/dFlYcHZiaTVqL2Iy/MHZhVzFoWjJWekww/a3YvTlRGTmVtRjVO/M1U1U0V3dS9hbkJu", integrantesQueen));
        
        List<IntegranteDTO> integrantesSinBandera = new ArrayList<>();
        integrantesSinBandera.add(new IntegranteDTO("Leonel García", "Vocalista", LocalDate.of(2000, 1, 1), "Activo"));
        integrantesSinBandera.add(new IntegranteDTO("Noel Schajris", "Vocalista", LocalDate.of(2000, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Sin bandera", "Banda", "Bolero", "https://imgs.search.brave.com/O0dJWerjwNBGaH2N6bykPv3OpRsS89RZaaAarCrWG7w/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vMjY5Y1JP/OGs1YUlFQkt3N0pn/ckwtTk9SeUtWS3FM/M0VCdDRKc1I2OTdr/dy9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlw/YldGbi9aWE11YzJz/dGMzUmhkR2xqL0xt/TnZiUzlwYldGblpY/TXYvYldWa2FXRXZh/VzFuTDJOdi9iRE12/TWpBeE56QXlNak10/L01EQXpNVEl6TFRn/ME1USTUvTnk1cWNH/Yw", integrantesSinBandera));
        
        List<IntegranteDTO> integrantesBTR = new ArrayList<>();
        integrantesBTR.add(new IntegranteDTO("Kendall Schmidt", "Vocalista", LocalDate.of(2009, 1, 1), "Inactivo"));
        integrantesBTR.add(new IntegranteDTO("James Maslow", "Vocalista", LocalDate.of(2009, 1, 1), "Inactivo"));
        integrantesBTR.add(new IntegranteDTO("Carlos Pena Jr.", "Vocalista", LocalDate.of(2009, 1, 1), "Inactivo"));
        integrantesBTR.add(new IntegranteDTO("Logan Henderson", "Vocalista", LocalDate.of(2009, 1, 1), "Inactivo"));
        bandas.add(new ArtistaDTO("Big Time Rush", "Banda", "Pop", "https://imgs.search.brave.com/HdcLLRup2oQyFI_oNF4it67_GxJo6GRpfHurHNhKiI8/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vdzktYi11/OWZ3RE4tRGZuWGVw/T2U2QWRBdkt0NVU3/THpVU0RFcWdWSFdm/SS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlw/TG5CcC9ibWx0Wnk1/amIyMHZiM0pwL1oy/bHVZV3h6THpSaUx6/STEvTDJFd0x6UmlN/alZoTUdVMC9ZVGt6/TW1ObU5qSXdNVEJt/L01XUXpOVFV5TVRJ/MU5qUmgvTG1wd1p3", integrantesBTR));
        
        List<IntegranteDTO> integrantesOD = new ArrayList<>();
        integrantesOD.add(new IntegranteDTO("Harry Styles", "Vocalista", LocalDate.of(2010, 1, 1), "Inactivo"));
        integrantesOD.add(new IntegranteDTO("Liam Payne", "Vocalista", LocalDate.of(2010, 1, 1), "Inactivo"));
        integrantesOD.add(new IntegranteDTO("Louis Tomlinson", "Vocalista", LocalDate.of(2010, 1, 1), "Inactivo"));
        integrantesOD.add(new IntegranteDTO("Niall Horan", "Vocalista", LocalDate.of(2010, 1, 1), "Inactivo"));
        integrantesOD.add(new IntegranteDTO("Zayn Malik", "Vocalista", LocalDate.of(2010, 1, 1), "Inactivo"));
        bandas.add(new ArtistaDTO("One Direction", "Banda", "Pop", "https://imgs.search.brave.com/OzhQx4JcybV8yYpaEG_wzAF8OmAyY1YXSHDL7FrHA3A/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vN0VRdE1Q/bHhaMFNXQ0pSdHFi/WEJvTy1uMlladXBq/ell0cEllT1p6LTdO/VS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/WVd4cy9jR0Z3WlhK/ekxtTnZiUzlwL2JX/Rm5aWE12YUdRdmIy/NWwvTFdScGNtVmpk/R2x2Ymkxei9aWEJw/WVMxd2IzSjBjbUZw/L2RDMXJabXBuY0hn/d016bHUvTm5ZM2JX/ODNMbXB3Wnc", integrantesOD));
        
        List<IntegranteDTO> integrantesCD9 = new ArrayList<>();
        integrantesCD9.add(new IntegranteDTO("Yankel Stevan", "Vocalista", LocalDate.of(2010, 1, 1), "Activo"));
        integrantesCD9.add(new IntegranteDTO("Alan Navarro", "Vocalista", LocalDate.of(2010, 1, 1), "Activo"));
        integrantesCD9.add(new IntegranteDTO("Jos Canela", "Vocalista", LocalDate.of(2010, 1, 1), "Activo"));
        integrantesCD9.add(new IntegranteDTO("Christopher Vélez", "Vocalista", LocalDate.of(2010, 1, 1), "Activo"));
        integrantesCD9.add(new IntegranteDTO("Dylan Ruiz", "Vocalista", LocalDate.of(2010, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("CD9", "Banda", "Pop", "https://imgs.search.brave.com/1lUKNNOM6LtIKl05pypgf8p-gbCl5_mtucNchdS576Y/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vRnp1aWZ0/UW81VTU3VnR0TktW/N2tpLTlKS09fcmM1/WGhEd0lFWlkyaGFF/QS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9aWGhqWld4/emFXOXlMbU52L2JT/NXRlQzh5TkRCNE1U/YzEvTDJacGJIUmxj/bk02Wm05eS9iV0Yw/S0hkbFluQXBPbkYx/L1lXeHBkSGtvTnpV/cEwyMWwvWkdsaEwz/QnBZM1IxY21Wei9M/ekl3TWpRdk1ETXZN/ekV2L016QTVOVGMx/T1M1cWNHYw", integrantesCD9));
        
        List<IntegranteDTO> integrantesPlanB = new ArrayList<>();
        integrantesPlanB.add(new IntegranteDTO("Chencho Corleone", "Vocalista", LocalDate.of(2002, 1, 1), "Activo"));
        integrantesPlanB.add(new IntegranteDTO("Maldy", "Vocalista", LocalDate.of(2002, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Plan B", "Banda", "Reggaeton", "https://imgs.search.brave.com/Xd-4iPnt8W7wHBQXBceDisYuq0r7-fTihV_-zr98E9g/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vRDJ2VnJF/QUk0cE5pZ2EyeHpH/ck51TjhPRkplZGx3/WDdQd1JnSHI0Snp0/VS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlo/YkdOby9aWFJ5YjI0/dVkyOXRMMk5rL2Jp/OXdiR0Z1TFdJdFpI/VnYvTFRZd1ltRTFO/alZrTFRrMC9ZMll0/TkRjMk5pMWlaR1Ux/L0xUaGlOakV3TnpO/ak1UZGkvTFhKbGMy/bDZaUzAzTlRBdS9h/bkJsWnc", integrantesPlanB));
        
        List<IntegranteDTO> integrantesEnjambre = new ArrayList<>();
        integrantesEnjambre.add(new IntegranteDTO("Ricardo López", "Vocalista/Guitarrista", LocalDate.of(2000, 1, 1), "Activo"));
        integrantesEnjambre.add(new IntegranteDTO("Abie Toiber", "Batería", LocalDate.of(2000, 1, 1), "Activo"));
        integrantesEnjambre.add(new IntegranteDTO("Juan Pablo Rodríguez", "Teclados", LocalDate.of(2000, 1, 1), "Activo"));
        integrantesEnjambre.add(new IntegranteDTO("Manuel Vázquez", "Bajo", LocalDate.of(2000, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Enjambre", "Banda", "Rock", "https://imgs.search.brave.com/apHIVbt4sM3fmXCjLIZexEhWhvQJ66J99lRZn8u1LPs/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vNXhISDFy/d3VRdkpudjdsSmRs/Z29IdkcxcGFtUmVT/a2NNOHBiQlB5SVR3/VS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkx/Y0d4di9ZV1F1ZDJs/cmFXMWxaR2xoL0xt/OXlaeTkzYVd0cGNH/VmsvYVdFdlkyOXRi/Vzl1Y3k5aC9MMkU1/TDBWdWFtRnRZbkps/L1gzTmxjMmtsUXpN/bFFqTnUvWDJadmRH/OW5jaVZETXlWQi9N/V1pwWTJFdWFuQm4", integrantesEnjambre));
        
        List<IntegranteDTO> integrantesBandaMS = new ArrayList<>();
        integrantesBandaMS.add(new IntegranteDTO("Alfredo Olivas", "Vocalista", LocalDate.of(2003, 1, 1), "Activo"));
        integrantesBandaMS.add(new IntegranteDTO("Erick García", "Bajista", LocalDate.of(2003, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Banda MS", "Banda", "Regional", "https://imgs.search.brave.com/a5xPcNht4f5_e6e4ywJc1cnSmhqiQzWVhVW0v5OgRdc/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20venBtX0x6/OFV2YXdnVENwV1Vw/czZ6aVBqeW5SU3lL/aFVza0E5Wm1PbE5C/WS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl3/YUc5MC9iM011WW1G/dVpITnBiblJ2L2Qy/NHVZMjl0TDNSb2RX/MWkvTHpJd05EUXpP/RFF3TG1wdy9aV2M", integrantesBandaMS));
        
        List<IntegranteDTO> integrantesMYA = new ArrayList<>();
        integrantesMYA.add(new IntegranteDTO("Maxi Espíndola", "Vocalista", LocalDate.of(2016, 1, 1), "Activo"));
        integrantesMYA.add(new IntegranteDTO("Agustín Bernasconi", "Vocalista", LocalDate.of(2016, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("MYA", "Banda", "Urbano", "https://imgs.search.brave.com/YVUK3sBd0HVyZGfRcM3sAW1VuJVqcpp3kboEO1SHAww/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vOHFYcU85/dXZHTWhFQ3RaeW1C/ajdSNlE3MTY1VmMy/Q05Ub2poQUxUTVFo/RS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9aV3hqYVhW/a1lXUmhibTkzL1pX/SXVZMjl0TDNkd0xX/TnYvYm5SbGJuUXZk/WEJzYjJGay9jeTh5/TURJekx6QTRMMDE1/L1lTNXFjR2M", integrantesMYA));
        
        List<IntegranteDTO> integrantesDeftones = new ArrayList<>();
        integrantesDeftones.add(new IntegranteDTO("Chino Moreno", "Vocalista", LocalDate.of(1988, 1, 1), "Activo"));
        integrantesDeftones.add(new IntegranteDTO("Stephen Carpenter", "Guitarrista", LocalDate.of(1988, 1, 1), "Activo"));
        integrantesDeftones.add(new IntegranteDTO("Abe Cunningham", "Batería", LocalDate.of(1988, 1, 1), "Activo"));
        integrantesDeftones.add(new IntegranteDTO("Sergio Vega", "Bajista", LocalDate.of(2009, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("Deftones", "Banda", "Rock", "https://imgs.search.brave.com/X-CpueiSaun0-xhO2gsvB4VWTYUBHrFLFfxmMsYIitw/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vdGpfdnRX/bEt6WU5UdXE5Wjd6/QmJnd21NbU91MzVO/TXFtVkxvZjhoOWhW/SS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl0/TG0xbC9aR2xoTFdG/dFlYcHZiaTVqL2Iy/MHZhVzFoWjJWekww/MHYvVFZZMVFsbHFV/WGhOUjBwdC9XVEpa/ZEZsWFNtcE5VekF3/L1RrUlplRXhVWnpO/WlZHZDAvV1ZkS2FF/NUVSbTFQUkVFMS9X/VEpHYTFoclJYbFlh/MFp4L1kwZGpRQzVx/Y0dj", integrantesDeftones));
        
        List<IntegranteDTO> integrantesTN = new ArrayList<>();
        integrantesTN.add(new IntegranteDTO("Jesse Rutherford", "Vocalista", LocalDate.of(2011, 1, 1), "Activo"));
        integrantesTN.add(new IntegranteDTO("Jeremy Freedman", "Guitarrista", LocalDate.of(2011, 1, 1), "Activo"));
        integrantesTN.add(new IntegranteDTO("Zach Abels", "Guitarrista", LocalDate.of(2011, 1, 1), "Activo"));
        integrantesTN.add(new IntegranteDTO("Mikey Margott", "Bajista", LocalDate.of(2011, 1, 1), "Activo"));
        integrantesTN.add(new IntegranteDTO("Brandon Fried", "Batería", LocalDate.of(2011, 1, 1), "Activo"));
        bandas.add(new ArtistaDTO("The neighbourhood", "Banda", "Pop", "https://imgs.search.brave.com/HM6kmJcQkUlplq6fkTlwUrMoGC5h8RY8QvctvGGs_mI/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vYzFkN2py/X0xYbnBoSHp1WHlJ/TnZTYjJqcUpGNTRS/QkJmVzNBOGtoMF83/by9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlw/YldGbi9aWE10Ym1F/dWMzTnNMV2x0L1lX/ZGxjeTFoYldGNmIy/NHUvWTI5dEwybHRZ/V2RsY3k5Si9Memd4/UmpJM1l6VkVTVmhN/L0xtcHdadw", integrantesTN));
        
        List<IntegranteDTO> integrantesGrupoFrontera = new ArrayList<>();
        bandas.add(new ArtistaDTO("Grupo Frontera", "Banda", "Regional", "https://imgs.search.brave.com/fNRhvFi-tXaHBh9kYZixM662I3AnGU8_2Jpr-5YLQoc/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vSE5zRWhE/ODA4UGtVa09fNW5h/VG5heE0xSHh0R3ZY/c0dFOWZGTjBveTlC/MC9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkw/YUdWbS9ZV1JsY2kx/eVpYTXVZMnh2L2RX/UnBibUZ5ZVM1amIy/MHYvY0hKcGRtRjBa/VjlwYldGbi9aWE12/ZDE4M05qQXNZMTlz/L2FXMXBkQ3htWDJG/MWRHOHMvY1Y5aGRY/UnZPbVZqYnk5Ti9R/VmxCWDBaVlNGSTBN/Rjl2L2RIUnBaVEV2/WjNKMWNHOHQvWm5K/dmJuUmxjbUV0Wlc1/MC9jbVYyYVhOMFlT/MWxjM0JoL2JtOXNM/bXB3Wnc", integrantesGrupoFrontera));
        
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
                "https://imgs.search.brave.com/KqEHko7WnF8zHFrDHfpaLIGXUS9Q7ihwgzNedXvfhGg/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vdVBaYXAt/SDNCTzBLX0VNYmVi/eVRXVnZ2U2VIb3Vy/R1oxVTk3TGFnWlZq/TS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl0/TG0xbC9aR2xoTFdG/dFlYcHZiaTVqL2Iy/MHZhVzFoWjJWekww/a3YvTmpGdVoxbHpa/RW80Y2t3dS9hbkJu",
                obtenerCancionesDeAlbum("Primera Estrella")
            ));
        }

        if ("Ariana Grande".equals(artistaDTO.getNombre())) {
            albumes.add(new AlbumDTO(
                "Yours Truly",
                LocalDate.of(2013, 8, 30),
                "Pop",
                "https://imgs.search.brave.com/Bf4xm_NVrhd1Xt-BKJ_YTQ7Kbnj8nK_Z8uB8nfvZfMo/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vYkZoekZz/QVlXT3NVQUxpZUpt/OEJmWUd2RERPRWRz/VDhZdVVteHhkRS1N/by9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl0/TG0xbC9aR2xoTFdG/dFlYcHZiaTVqL2Iy/MHZhVzFoWjJWekww/MHYvVFZZMVFrMXFR/VFJPYWtVMS9UVVJa/TWs5V05VSk5iRFZD/L1lXNUNibGhyUm5S/YVZHZDMvVFZSRk1V/NVVTWHBQUkVWQS9M/bXB3Wnc",
                obtenerCancionesDeAlbum("Yours Truly")
            ));
            albumes.add(new AlbumDTO(
                "Sweetener",
                LocalDate.of(2018, 8, 17),
                "Pop",
                "https://imgs.search.brave.com/-2Zqf5E7C2sWjqfgE0Kl8MWHeJRr4yAt9ulgdSXKA-g/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vaHhXSHls/c1pic0pVeFBjalYx/TUdfRVR5eGh5Y2lJ/d1NHWkNOak51TS1t/by9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl0/TG0xbC9aR2xoTFdG/dFlYcHZiaTVqL2Iy/MHZhVzFoWjJWekww/a3YvTlRGNGRFSnpl/akJIUTB3dS9hbkJu",
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
