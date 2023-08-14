package by.akulich.gcs.controllers;

import by.akulich.gcs.dao.GiftCertificateDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gift-certificates")
public class GiftCertificatesController {

    private final GiftCertificateDAO giftCertificateDAO;
    private final ObjectMapper objectMapper= new ObjectMapper();

    @Autowired
    public GiftCertificatesController(GiftCertificateDAO giftCertificateDAO) {
        this.giftCertificateDAO = giftCertificateDAO;
    }

    @GetMapping()
    public String getAllGiftCertificates() {
        try {
            return objectMapper.writeValueAsString(giftCertificateDAO.getAll());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{name}")
    public String getGiftCertificateByName(@PathVariable String name) {
        try {
            return objectMapper.writeValueAsString(giftCertificateDAO.getByName(name));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
