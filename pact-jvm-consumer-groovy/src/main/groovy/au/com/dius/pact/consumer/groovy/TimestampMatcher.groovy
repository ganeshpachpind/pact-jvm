package au.com.dius.pact.consumer.groovy

import org.apache.commons.lang3.time.DateFormatUtils

/**
 * Matcher for timestamps
 */
@SuppressWarnings('UnnecessaryGetter')
class TimestampMatcher extends Matcher {

  String pattern

  String getPattern() {
    pattern ?: DateFormatUtils.ISO_DATETIME_FORMAT.pattern
  }

  def getMatcher() {
    new au.com.dius.pact.model.matchingrules.TimestampMatcher(getPattern())
  }

  def getValue() {
    if (values == null) {
      DateFormatUtils.format(new Date(), getPattern())
    } else {
      values
    }
  }

}
