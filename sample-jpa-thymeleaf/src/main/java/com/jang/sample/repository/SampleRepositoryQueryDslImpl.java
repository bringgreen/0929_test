package com.jang.sample.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

//import com.jang.sample.domain.QSample;
import com.jang.sample.domain.Sample;
import com.querydsl.jpa.JPQLQuery;

@Repository
public class SampleRepositoryQueryDslImpl extends QuerydslRepositorySupport implements SampleRepositoryQueryDsl {

    public SampleRepositoryQueryDslImpl() {
        super(Sample.class);
    }

	@Override
	public List<Sample> findByNameLikeDescriptionLike(Map param) {
//		// TODO Auto-generated method stub
//		final QSample sample = QSample.sample; 
//        final JPQLQuery<Sample> query;
//        String searchKeyword = param.get("searchKeyword").toString();
//        String searchCondition = param.get("searchCondition").toString();
//
//        switch( searchCondition ) {
//            case "name":
//                query = from(sample)
//                        .where(sample.name.likeIgnoreCase(searchKeyword + "%"));
//                break;
//            case "description":
//                query = from(sample)
//                        .where(sample.description.likeIgnoreCase(searchKeyword + "%"));
//                
//                break;
//            case "all":
//                //query = from(sample).fetchAll();
//                query = from(sample)
//                .where(sample.name.likeIgnoreCase(searchKeyword + "%")
//                        .or(sample.description.likeIgnoreCase(searchKeyword + "%")));
//                break;
//            default:
//                throw new IllegalArgumentException();
//        }
//       
//        Sort sort = Sort.by(Sort.Direction.DESC, "name");
//        final List<Sample> list = getQuerydsl().applySorting(sort, query).fetch();
       
       //sort = sort.and(new Sort(Sort.Direction.DESC, "count"))
        //final List<Sample> list = getQuerydsl().applyPagination(pageable, query).fetch();
        return null;
	}

	
    public Page<Sample> searchPage(final Map param, final Pageable pageable) {
		//final QSample sample = QSample.sample; 
        final JPQLQuery<Sample> query;
        String searchKeyword = param.get("searchKeyword").toString();
        String searchCondition = param.get("searchCondition").toString();

//        switch( searchCondition ) {
//            case "name":
//                query = from(sample)
//                        .where(sample.name.likeIgnoreCase(searchKeyword + "%"));
//                break;
//            case "description":
//                query = from(sample)
//                        .where(sample.description.likeIgnoreCase(searchKeyword + "%"));
//                
//                break;
//            case "all":
//                //query = from(sample).fetchAll();
//                query = from(sample)
//                .where(sample.name.likeIgnoreCase(searchKeyword + "%")
//                        .or(sample.description.likeIgnoreCase(searchKeyword + "%")));
//                break;
//            default:
//                throw new IllegalArgumentException();
//        }
       
       
        //final List<Sample> accounts = getQuerydsl().applyPagination(pageable, query).fetch();
        return null;
    }
}
