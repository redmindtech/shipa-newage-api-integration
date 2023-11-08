package com.shipa.newage.mapstruct;

import com.shipa.newage.entity.ShipaOrder;
import com.shipa.newage.entity.ShipaOrderPackages;
import com.shipa.newage.response.ShipaOrderPackagesResponse;
import com.shipa.newage.response.ShipaOrderResponse;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-08T23:28:07+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ShipaOrderMapperImpl implements ShipaOrderMapper {

    @Override
    public ShipaOrderResponse shipaOrderToShipaOrderResponse(ShipaOrder shipaOrder) {
        if ( shipaOrder == null ) {
            return null;
        }

        ShipaOrderResponse shipaOrderResponse = new ShipaOrderResponse();

        if ( shipaOrder.getCreationDate() != null ) {
            shipaOrderResponse.setCreationDate( DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ).format( shipaOrder.getCreationDate() ) );
        }
        if ( shipaOrder.getLastModifiedDate() != null ) {
            shipaOrderResponse.setLastModifiedDate( DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" ).format( shipaOrder.getLastModifiedDate() ) );
        }
        shipaOrderResponse.setId( shipaOrder.getId() );
        shipaOrderResponse.setCustomerRefNo( shipaOrder.getCustomerRefNo() );
        shipaOrderResponse.setOrderType( shipaOrder.getOrderType() );
        shipaOrderResponse.setCategory( shipaOrder.getCategory() );
        shipaOrderResponse.setOriginContactName( shipaOrder.getOriginContactName() );
        shipaOrderResponse.setOriginContactNo( shipaOrder.getOriginContactNo() );
        shipaOrderResponse.setOriginCity( shipaOrder.getOriginCity() );
        shipaOrderResponse.setOriginCountry( shipaOrder.getOriginCountry() );
        shipaOrderResponse.setOriginAddress( shipaOrder.getOriginAddress() );
        shipaOrderResponse.setDestinationContactName( shipaOrder.getDestinationContactName() );
        shipaOrderResponse.setDestinationContactNo( shipaOrder.getDestinationContactNo() );
        shipaOrderResponse.setDestinationCity( shipaOrder.getDestinationCity() );
        shipaOrderResponse.setDestinationCountry( shipaOrder.getDestinationCountry() );
        shipaOrderResponse.setDestinationAddress( shipaOrder.getDestinationAddress() );
        shipaOrderResponse.setShipaApiStatus( shipaOrder.getShipaApiStatus() );
        shipaOrderResponse.setShipaRef( shipaOrder.getShipaRef() );
        byte[] awbPdf = shipaOrder.getAwbPdf();
        if ( awbPdf != null ) {
            shipaOrderResponse.setAwbPdf( Arrays.copyOf( awbPdf, awbPdf.length ) );
        }
        shipaOrderResponse.setCreatedBy( shipaOrder.getCreatedBy() );
        shipaOrderResponse.setLastModifiedBy( shipaOrder.getLastModifiedBy() );
        shipaOrderResponse.setShipaOrderPackages( shipaOrderPackagesListToShipaOrderPackagesResponseList( shipaOrder.getShipaOrderPackages() ) );

        return shipaOrderResponse;
    }

    @Override
    public List<ShipaOrderResponse> shipaOrderToShipaOrderResponse(List<ShipaOrder> shipaOrder) {
        if ( shipaOrder == null ) {
            return null;
        }

        List<ShipaOrderResponse> list = new ArrayList<ShipaOrderResponse>( shipaOrder.size() );
        for ( ShipaOrder shipaOrder1 : shipaOrder ) {
            list.add( shipaOrderToShipaOrderResponse( shipaOrder1 ) );
        }

        return list;
    }

    protected ShipaOrderPackagesResponse shipaOrderPackagesToShipaOrderPackagesResponse(ShipaOrderPackages shipaOrderPackages) {
        if ( shipaOrderPackages == null ) {
            return null;
        }

        ShipaOrderPackagesResponse shipaOrderPackagesResponse = new ShipaOrderPackagesResponse();

        shipaOrderPackagesResponse.setId( shipaOrderPackages.getId() );
        shipaOrderPackagesResponse.setName( shipaOrderPackages.getName() );
        shipaOrderPackagesResponse.setCustomerRefNo( shipaOrderPackages.getCustomerRefNo() );
        shipaOrderPackagesResponse.setCreatedBy( shipaOrderPackages.getCreatedBy() );
        if ( shipaOrderPackages.getCreationDate() != null ) {
            shipaOrderPackagesResponse.setCreationDate( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( shipaOrderPackages.getCreationDate() ) );
        }
        shipaOrderPackagesResponse.setLastModifiedBy( shipaOrderPackages.getLastModifiedBy() );
        if ( shipaOrderPackages.getLastModifiedDate() != null ) {
            shipaOrderPackagesResponse.setLastModifiedDate( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( shipaOrderPackages.getLastModifiedDate() ) );
        }

        return shipaOrderPackagesResponse;
    }

    protected List<ShipaOrderPackagesResponse> shipaOrderPackagesListToShipaOrderPackagesResponseList(List<ShipaOrderPackages> list) {
        if ( list == null ) {
            return null;
        }

        List<ShipaOrderPackagesResponse> list1 = new ArrayList<ShipaOrderPackagesResponse>( list.size() );
        for ( ShipaOrderPackages shipaOrderPackages : list ) {
            list1.add( shipaOrderPackagesToShipaOrderPackagesResponse( shipaOrderPackages ) );
        }

        return list1;
    }
}
