package com.example.chargingstations.model


import com.google.gson.annotations.SerializedName

class StationEntity : ArrayList<StationEntity.StationEntityItem>() {
    data class StationEntityItem(
        @SerializedName("AddressInfo")
        val addressInfo: AddressInfoEntity? = null,
        @SerializedName("Connections")
        val connections: List<ConnectionEntity?>? = null,
        @SerializedName("DataProvider")
        val dataProvider: DataProviderEntity? = null,
        @SerializedName("DataProviderID")
        val dataProviderID: Int? = null,
        @SerializedName("DataProvidersReference")
        val dataProvidersReference: String? = null,
        @SerializedName("DataQualityLevel")
        val dataQualityLevel: Int? = null,
        @SerializedName("DateCreated")
        val dateCreated: String? = null,
        @SerializedName("DateLastConfirmed")
        val dateLastConfirmed: String? = null,
        @SerializedName("DateLastStatusUpdate")
        val dateLastStatusUpdate: String? = null,
        @SerializedName("DateLastVerified")
        val dateLastVerified: String? = null,
        @SerializedName("DatePlanned")
        val datePlanned: Any? = null,
        @SerializedName("GeneralComments")
        val generalComments: String? = null,
        @SerializedName("ID")
        val iD: Int= -1,
        @SerializedName("IsRecentlyVerified")
        val isRecentlyVerified: Boolean? = null,
        @SerializedName("MediaItems")
        val mediaItems: Any? = null,
        @SerializedName("MetadataValues")
        val metadataValues: List<MetadataValue?>? = null,
        @SerializedName("NumberOfPoints")
        val numberOfPoints: Int? = null,
        @SerializedName("OperatorID")
        val operatorID: Int? = null,
        @SerializedName("OperatorInfo")
        val operatorInfo: OperatorInfoEntity,
        @SerializedName("OperatorsReference")
        val operatorsReference: String? = null,
        @SerializedName("ParentChargePointID")
        val parentChargePointID: Any? = null,
        @SerializedName("PercentageSimilarity")
        val percentageSimilarity: Any? = null,
        @SerializedName("StatusType")
        val statusType: StatusTypeEntity? = null,
        @SerializedName("StatusTypeID")
        val statusTypeID: Int? = null,
        @SerializedName("SubmissionStatus")
        val submissionStatus: SubmissionStatus? = null,
        @SerializedName("SubmissionStatusTypeID")
        val submissionStatusTypeID: Int? = null,
        @SerializedName("UUID")
        val uUID: String? = null,
        @SerializedName("UsageCost")
        val usageCost: String? = null,
        @SerializedName("UsageType")
        val usageType: UsageType? = null,
        @SerializedName("UsageTypeID")
        val usageTypeID: Int? = null,
        @SerializedName("UserComments")
        val userComments: List<UserComment?>? = null
    ) {
        data class AddressInfoEntity(
            @SerializedName("AccessComments")
            val accessComments: Any? = null,
            @SerializedName("AddressLine1")
            val addressLine1: String? = null,
            @SerializedName("AddressLine2")
            val addressLine2: Any? = null,
            @SerializedName("ContactEmail")
            val contactEmail: Any? = null,
            @SerializedName("ContactTelephone1")
            val contactTelephone1: Any? = null,
            @SerializedName("ContactTelephone2")
            val contactTelephone2: Any? = null,
            @SerializedName("Country")
            val country: Country? = null,
            @SerializedName("CountryID")
            val countryID: Int? = null,
            @SerializedName("Distance")
            val distance: Double? = null,
            @SerializedName("DistanceUnit")
            val distanceUnit: Int? = null,
            @SerializedName("ID")
            val iD: Int? = null,
            @SerializedName("Latitude")
            val latitude: Double = 0.0,
            @SerializedName("Longitude")
            val longitude: Double=0.0,
            @SerializedName("Postcode")
            val postcode: String? = null,
            @SerializedName("RelatedURL")
            val relatedURL: String? = null,
            @SerializedName("StateOrProvince")
            val stateOrProvince: String? = null,
            @SerializedName("Title")
            val title: String = "",
            @SerializedName("Town")
            val town: String? = null
        ) {
            data class Country(
                @SerializedName("ContinentCode")
                val continentCode: String? = null,
                @SerializedName("ID")
                val iD: Int? = null,
                @SerializedName("ISOCode")
                val iSOCode: String? = null,
                @SerializedName("Title")
                val title: String? = null
            )
        }

        data class ConnectionEntity(
            @SerializedName("Amps")
            val amps: Int? = null,
            @SerializedName("Comments")
            val comments: Any? = null,
            @SerializedName("ConnectionType")
            val connectionType: ConnectionTypeEntity? = null,
            @SerializedName("ConnectionTypeID")
            val connectionTypeID: Int? = null,
            @SerializedName("CurrentType")
            val currentType: CurrentType? = null,
            @SerializedName("CurrentTypeID")
            val currentTypeID: Int? = null,
            @SerializedName("ID")
            val iD: Int? = null,
            @SerializedName("Level")
            val level: Level? = null,
            @SerializedName("LevelID")
            val levelID: Int? = null,
            @SerializedName("PowerKW")
            val powerKW: Double? = null,
            @SerializedName("Quantity")
            val quantity: Int? = null,
            @SerializedName("Reference")
            val reference: Any? = null,
            @SerializedName("StatusType")
            val statusType: StatusTypeEntity? = null,
            @SerializedName("StatusTypeID")
            val statusTypeID: Int? = null,
            @SerializedName("Voltage")
            val voltage: Int? = null
        ) {
            data class ConnectionTypeEntity(
                @SerializedName("FormalName")
                val formalName: String? = null,
                @SerializedName("ID")
                val iD: Int? = null,
                @SerializedName("IsDiscontinued")
                val isDiscontinued: Boolean? = null,
                @SerializedName("IsObsolete")
                val isObsolete: Boolean? = null,
                @SerializedName("Title")
                val title: String? = null
            )

            data class CurrentType(
                @SerializedName("Description")
                val description: String? = null,
                @SerializedName("ID")
                val iD: Int? = null,
                @SerializedName("Title")
                val title: String? = null
            )

            data class Level(
                @SerializedName("Comments")
                val comments: String? = null,
                @SerializedName("ID")
                val iD: Int? = null,
                @SerializedName("IsFastChargeCapable")
                val isFastChargeCapable: Boolean? = null,
                @SerializedName("Title")
                val title: String? = null
            )

            data class StatusTypeEntity(
                @SerializedName("ID")
                val iD: Int? = null,
                @SerializedName("IsOperational")
                val isOperational: Boolean? = null,
                @SerializedName("IsUserSelectable")
                val isUserSelectable: Boolean? = null,
                @SerializedName("Title")
                val title: String? = null
            )
        }

        data class DataProviderEntity(
            @SerializedName("Comments")
            val comments: Any? = null,
            @SerializedName("DataProviderStatusType")
            val dataProviderStatusType: DataProviderStatusType? = null,
            @SerializedName("DateLastImported")
            val dateLastImported: Any? = null,
            @SerializedName("ID")
            val iD: Int? = null,
            @SerializedName("IsApprovedImport")
            val isApprovedImport: Boolean? = null,
            @SerializedName("IsOpenDataLicensed")
            val isOpenDataLicensed: Boolean? = null,
            @SerializedName("IsRestrictedEdit")
            val isRestrictedEdit: Boolean? = null,
            @SerializedName("License")
            val license: String? = null,
            @SerializedName("Title")
            val title: String? = null,
            @SerializedName("WebsiteURL")
            val websiteURL: String? = null
        ) {
            data class DataProviderStatusType(
                @SerializedName("ID")
                val iD: Int? = null,
                @SerializedName("IsProviderEnabled")
                val isProviderEnabled: Boolean? = null,
                @SerializedName("Title")
                val title: String? = null
            )
        }

        data class MetadataValue(
            @SerializedName("ID")
            val iD: Int? = null,
            @SerializedName("ItemValue")
            val itemValue: String? = null,
            @SerializedName("MetadataFieldID")
            val metadataFieldID: Int? = null,
            @SerializedName("MetadataFieldOption")
            val metadataFieldOption: Any? = null,
            @SerializedName("MetadataFieldOptionID")
            val metadataFieldOptionID: Any? = null
        )

        data class OperatorInfoEntity(
            @SerializedName("AddressInfo")
            val addressInfo: AddressInfoEntity? = null,
            @SerializedName("BookingURL")
            val bookingURL: Any? = null,
            @SerializedName("Comments")
            val comments: Any? = null,
            @SerializedName("ContactEmail")
            val contactEmail: String = "",
            @SerializedName("FaultReportEmail")
            val faultReportEmail: Any? = null,
            @SerializedName("ID")
            val iD: Int? = null,
            @SerializedName("IsPrivateIndividual")
            val isPrivateIndividual: Boolean? = null,
            @SerializedName("IsRestrictedEdit")
            val isRestrictedEdit: Boolean? = null,
            @SerializedName("PhonePrimaryContact")
            val phonePrimaryContact: String = "",
            @SerializedName("PhoneSecondaryContact")
            val phoneSecondaryContact: Any? = null,
            @SerializedName("Title")
            val title: String = "",
            @SerializedName("WebsiteURL")
            val websiteURL: String = ""
        )

        data class StatusTypeEntity(
            @SerializedName("ID")
            val iD: Int? = null,
            @SerializedName("IsOperational")
            val isOperational: Boolean = false,
            @SerializedName("IsUserSelectable")
            val isUserSelectable: Boolean? = null,
            @SerializedName("Title")
            val title: String? = null
        )

        data class SubmissionStatus(
            @SerializedName("ID")
            val iD: Int? = null,
            @SerializedName("IsLive")
            val isLive: Boolean? = null,
            @SerializedName("Title")
            val title: String? = null
        )

        data class UsageType(
            @SerializedName("ID")
            val iD: Int? = null,
            @SerializedName("IsAccessKeyRequired")
            val isAccessKeyRequired: Boolean? = null,
            @SerializedName("IsMembershipRequired")
            val isMembershipRequired: Boolean? = null,
            @SerializedName("IsPayAtLocation")
            val isPayAtLocation: Boolean? = null,
            @SerializedName("Title")
            val title: String? = null
        )

        data class UserComment(
            @SerializedName("ChargePointID")
            val chargePointID: Int? = null,
            @SerializedName("CheckinStatusType")
            val checkinStatusType: CheckinStatusType? = null,
            @SerializedName("CheckinStatusTypeID")
            val checkinStatusTypeID: Int? = null,
            @SerializedName("Comment")
            val comment: String? = null,
            @SerializedName("CommentType")
            val commentType: CommentType? = null,
            @SerializedName("CommentTypeID")
            val commentTypeID: Int? = null,
            @SerializedName("DateCreated")
            val dateCreated: String? = null,
            @SerializedName("ID")
            val iD: Int? = null,
            @SerializedName("IsActionedByEditor")
            val isActionedByEditor: Any? = null,
            @SerializedName("Rating")
            val rating: Int? = null,
            @SerializedName("RelatedURL")
            val relatedURL: Any? = null,
            @SerializedName("User")
            val user: User? = null,
            @SerializedName("UserName")
            val userName: String? = null
        ) {
            data class CheckinStatusType(
                @SerializedName("ID")
                val iD: Int? = null,
                @SerializedName("IsAutomatedCheckin")
                val isAutomatedCheckin: Boolean? = null,
                @SerializedName("IsPositive")
                val isPositive: Boolean? = null,
                @SerializedName("Title")
                val title: String? = null
            )

            data class CommentType(
                @SerializedName("ID")
                val iD: Int? = null,
                @SerializedName("Title")
                val title: String? = null
            )

            data class User(
                @SerializedName("APIKey")
                val aPIKey: Any? = null,
                @SerializedName("CurrentSessionToken")
                val currentSessionToken: Any? = null,
                @SerializedName("DateCreated")
                val dateCreated: Any? = null,
                @SerializedName("DateLastLogin")
                val dateLastLogin: Any? = null,
                @SerializedName("EmailAddress")
                val emailAddress: Any? = null,
                @SerializedName("EmailHash")
                val emailHash: Any? = null,
                @SerializedName("ID")
                val iD: Int? = null,
                @SerializedName("Identifier")
                val identifier: Any? = null,
                @SerializedName("IdentityProvider")
                val identityProvider: Any? = null,
                @SerializedName("IsCurrentSessionTokenValid")
                val isCurrentSessionTokenValid: Any? = null,
                @SerializedName("IsEmergencyChargingProvider")
                val isEmergencyChargingProvider: Any? = null,
                @SerializedName("IsProfilePublic")
                val isProfilePublic: Any? = null,
                @SerializedName("IsPublicChargingProvider")
                val isPublicChargingProvider: Any? = null,
                @SerializedName("Latitude")
                val latitude: Any? = null,
                @SerializedName("Location")
                val location: Any? = null,
                @SerializedName("Longitude")
                val longitude: Any? = null,
                @SerializedName("Permissions")
                val permissions: Any? = null,
                @SerializedName("PermissionsRequested")
                val permissionsRequested: Any? = null,
                @SerializedName("Profile")
                val profile: Any? = null,
                @SerializedName("ProfileImageURL")
                val profileImageURL: String? = null,
                @SerializedName("ReputationPoints")
                val reputationPoints: Int? = null,
                @SerializedName("SyncedSettings")
                val syncedSettings: Any? = null,
                @SerializedName("Username")
                val username: String? = null,
                @SerializedName("WebsiteURL")
                val websiteURL: Any? = null
            )
        }
    }
}