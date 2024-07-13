package weval.dazzi.api.entity.seller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import weval.dazzi.api.entity.seller.dto.RequestSeller;
import weval.dazzi.api.entity.seller.dto.ResponseSeller;


@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerApi {

    private final SellerService sellerService;

    @GetMapping
    public ResponseSeller.SellerAllInfo sellerInfo(HttpServletRequest request) {
        return sellerService.sellerInfo(request.getHeader("authorizationToken"));
    }

    @PostMapping
    public ResponseSeller.SellerIdInfo createSeller(HttpServletRequest request, @RequestBody RequestSeller.CreateSeller createSeller) {
        createSeller.setToken(request);
        return sellerService.createSeller(createSeller);
    }

    @PatchMapping
    public ResponseSeller.SellerIdInfo updateSeller(@RequestBody RequestSeller.UpdateSeller updateSeller) {
        return sellerService.updateSeller(updateSeller);
    }
}
