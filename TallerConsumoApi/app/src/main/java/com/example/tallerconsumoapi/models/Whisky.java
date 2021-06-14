package com.example.tallerconsumoapi.models;

import com.google.gson.annotations.SerializedName;

public class Whisky {

    @SerializedName("slug")
    private String SlugWhisky;

    @SerializedName("name")
    private String NameWhisky;

    @SerializedName("base_currency")
    private String BaseWhisky;

    @SerializedName("url")
    private String UrlWhisky;

    @SerializedName("dt")
    private String date;

    @SerializedName("winning_bid_min")
    private String WinningBidMin;

    @SerializedName("winning_bid_mean")
    private String WinningBidMean;

    @SerializedName("auction_trading_volume")
    private String TradingVolume;

    public String getSlugWhisky() {
        return SlugWhisky;
    }

    public void setSlugWhisky(String slugWhisky) {
        SlugWhisky = slugWhisky;
    }

    public String getNameWhisky() {
        return NameWhisky;
    }

    public void setNameWhisky(String nameWhisky) {
        NameWhisky = nameWhisky;
    }

    public String getBaseWhisky() {
        return BaseWhisky;
    }

    public void setBaseWhisky(String baseWhisky) {
        BaseWhisky = baseWhisky;
    }

    public String getUrlWhisky() {
        return UrlWhisky;
    }

    public void setUrlWhisky(String urlWhisky) {
        UrlWhisky = urlWhisky;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWinningBidMin() {
        return WinningBidMin;
    }

    public void setWinningBidMin(String winningBidMin) {
        WinningBidMin = winningBidMin;
    }

    public String getWinningBidMean() {
        return WinningBidMean;
    }

    public void setWinningBidMean(String winningBidMean) {
        WinningBidMean = winningBidMean;
    }

    public String getTradingVolume() {
        return TradingVolume;
    }

    public void setTradingVolume(String tradingVolume) {
        TradingVolume = tradingVolume;
    }
}
