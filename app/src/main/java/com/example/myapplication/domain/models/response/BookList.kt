package com.example.myapplication.domain.models.response

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

data class BookList(
    val items: List<Item>? = listOf(),
    val kind: String? = "",
    val totalItems: Int? = 0
)

data class Item(
    val accessInfo: AccessInfo? = null,
    val etag: String? = "",
    val id: String? = "",
    val kind: String? = "",
    val saleInfo: SaleInfo? = null,
    val searchInfo: SearchInfo? = null,
    val selfLink: String? = "",
    val volumeInfo: VolumeInfo? = null
)

data class AccessInfo(
    val accessViewStatus: String? = "",
    val country: String? = "",
    val embeddable: Boolean? = false,
    val epub: Epub? = null,
    val pdf: Pdf? = null,
    val publicDomain: Boolean? = false,
    val quoteSharingAllowed: Boolean? = false,
    val textToSpeechPermission: String? = "",
    val viewability: String? = "",
    val webReaderLink: String? = ""
)

data class SaleInfo(
    val country: String? = "",
    val isEbook: Boolean? = false,
    val saleability: String? = ""
)

data class SearchInfo(
    val textSnippet: String? = ""
)

data class VolumeInfo(
    val allowAnonLogging: Boolean? = false,
    val authors: List<String>? = arrayListOf(),
    val averageRating: Int? = 0,
    val canonicalVolumeLink: String? = "",
    val categories: List<String>? = arrayListOf(),
    val contentVersion: String? = "",
    val description: String? = "",
    val imageLinks: ImageLinks,
    val industryIdentifiers: List<IndustryIdentifier>,
    val infoLink: String? = "",
    val language: String? = "",
    val maturityRating: String? = "",
    val pageCount: Int? = 0,
    val panelizationSummary: PanelizationSummary,
    val previewLink: String? = "",
    val prIntType: String? = "",
    val publishedDate: String? = "",
    val publisher: String? = "",
    val ratingsCount: Int? = 0,
    val readingModes: ReadingModes,
    val subtitle: String? = "",
    val title: String? = ""
)

data class Epub(
    val isAvailable: Boolean? = false
)

data class Pdf(
    val isAvailable: Boolean? = false
)

data class ImageLinks(
    val smallThumbnail: String? = "",
    val thumbnail: String? = ""
)

data class IndustryIdentifier(
    val identifier: String? = "",
    val type: String? = ""
)

data class PanelizationSummary(
    val containsEpubBubbles: Boolean? = false,
    val containsImageBubbles: Boolean? = false
)

data class ReadingModes(
    val image: Boolean? = false,
    val text: Boolean? = false
)