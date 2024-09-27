package upc.edu.pe.api_mobile_backend.rentalservice.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.api_mobile_backend.rentalservice.domain.model.Card;
import upc.edu.pe.api_mobile_backend.rentalservice.domain.services.CardService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
    }

    @GetMapping("/user/{userId}")
    public List<Card> getCardsByUserId(@PathVariable Long userId) {
        return cardService.getCardsByUserId(userId);
    }
}
