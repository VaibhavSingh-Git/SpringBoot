package com.app.myJob.review;

import com.app.myJob.company.Company;
import com.app.myJob.company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

     @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReview(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReviews(@PathVariable Long companyId, @RequestBody Review review){
        boolean isAdded = reviewService.addReview(companyId,review);
        if(isAdded)
        return new ResponseEntity<>("Review Added Successfully",HttpStatus.OK);
        else{
            return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review>getReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        Review review = reviewService.getReview(companyId,reviewId);
        if(review != null)
            return new ResponseEntity<>(review,HttpStatus.OK);
        else
            return new ResponseEntity<>(review,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,@RequestBody Review review){
        boolean isReviewUpdated = reviewService.updateReview(companyId,reviewId,review);
        if(isReviewUpdated)
            return new ResponseEntity<>("Review Updated Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Review Not Updated",HttpStatus.OK);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReview(companyId,reviewId);
        if(isReviewDeleted)
            return new ResponseEntity<>("Review Deleted Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Review Not Deleted",HttpStatus.OK);
    }
}
