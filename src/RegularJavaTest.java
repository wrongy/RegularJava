import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RegularJavaTest {

    @ParameterizedTest
    @ValueSource(strings = {"145.9.3.234", "1.1.1.1", "127.0.0.9", "0.0.0.0", "255.255.255.255", "167.14.0.255"})
    void validIp(String ip) {
        assertTrue(RegularJava.validIp(ip));
    }

    @ParameterizedTest
    @ValueSource(strings = {"145.9.3.534", "276. jjf. ogj.", "....", "12323.398", "255,255.34,6", "A8j.67.y.2"})
    void inValidIp(String ip){
        assertFalse(RegularJava.validIp(ip));
    }

    @ParameterizedTest
    @ValueSource(strings = {"e02fd0e4-00fd-090A-ca30-0d00a0038ba0", "b0d4ce5d-2757-4699-948c-cfa72ba94f86", "bdb62d89-cede-11e4-b12b-d4ae52b5e909",
            "04030201-0605-0807-090a-0b0c0d0e0f10", "f06c3c8d-b2c2-4cc6-9a1a-8b3b3c82b9f0", "ff798e9f-E182-4a0f-Af78-224dbb45de69"})
    void validGUID(String guid) {
        assertTrue(RegularJava.validGUID(guid));
    }

    @ParameterizedTest
    @ValueSource(strings = {"126176-fn37-237d-3742-jhfbhbhdujnje", "e02fd0e400fd090Aca300d00a0038ba0"})
    void inValidGUID(String guid) {
        assertFalse(RegularJava.validGUID(guid));
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://www.example.com", "http://example.com", "https://vk.com/im?sel=222238038",
    "https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.1",
            "https://www.example.additional-domain.com:80/folder/chosen_fo?access=administrator&info=full#url5"})
    void validURl(String url) {
        assertTrue(RegularJava.validURl(url));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Just Text", "http://a.com", "https://ghghg.hhj...hdsk.com", "www.com"})
    void inValidURl(String url) {
        assertFalse(RegularJava.validURl(url));
    }

    @ParameterizedTest
    @ValueSource(strings = {"C00l_Pass", "SupperPas1"})
    void validPassword(String passwd) {
        assertTrue(RegularJava.validPassword(passwd));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Cool_pass", "C00l", "2    kjfnG"})
    void inValidPassword(String passwd) {
        assertFalse(RegularJava.validPassword(passwd));
    }
}